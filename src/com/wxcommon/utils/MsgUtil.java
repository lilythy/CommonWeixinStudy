package com.wxcommon.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wxcommon.conf.Constants;
import com.wxcommon.entity.Article;
import com.wxcommon.entity.BaseMsg;
import com.wxcommon.entity.Music;
import com.wxcommon.entity.MusicMsg;
import com.wxcommon.entity.NewsMsg;
import com.wxcommon.entity.TextMsg;

public class MsgUtil {
	
	
	public static Map<String, String> parseReqXml(HttpServletRequest request) throws IOException {
		Map<String, String> reqMap = new HashMap<String, String>();
		ServletInputStream weixinStream = null;
		
		try {
			weixinStream = request.getInputStream();
			SAXReader saxReader = new SAXReader();
			Document readDocument = saxReader.read(weixinStream);
			
			Element root = readDocument.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> elementList = root.elements();
			
			for(Element element : elementList) reqMap.put(element.getName(), element.getText());
			
		}catch (DocumentException e) {
			
			e.printStackTrace();
			
		} finally {
			weixinStream.close();
			weixinStream = null;
		}

		return reqMap;
	}
	
	/**
	 * 文本消息回复
	 * @param content
	 * @return
	 */
	public static String textMsgReplay(String content, BaseMsg baseMsg) {
		TextMsg textMsg = new TextMsg();
		
		textMsg.setFromUserName(baseMsg.getFromUserName());
		textMsg.setToUserName(baseMsg.getToUserName());
		textMsg.setCreateTime(baseMsg.getCreateTime());
		textMsg.setMsgType(Constants.MSG_TEXT);
		textMsg.setContent(content);
		
		return objMsgToXml(textMsg);
	}
	
	/**
	 * 音乐消息回复
	 * @param music
	 * @return
	 */
	public static String musicMsgReplay(Music music, BaseMsg baseMsg) {
		MusicMsg musicMsg = new MusicMsg();
		
		musicMsg.setToUserName(baseMsg.getToUserName());
		musicMsg.setFromUserName(baseMsg.getFromUserName());
		musicMsg.setCreateTime(baseMsg.getCreateTime());
		musicMsg.setMsgType(Constants.MSG_MUSIC);
		musicMsg.setMusic(music);
		
		return objMsgToXml(musicMsg);
	}
	
	/**
	 * 图文消息回复
	 * @param list
	 * @param num
	 * @return
	 */
	public static String newsMsgReplay(List<Article> list, int num, BaseMsg baseMsg) {
		NewsMsg newsMsg = new NewsMsg();
		
		newsMsg.setToUserName(baseMsg.getToUserName());
		newsMsg.setFromUserName(baseMsg.getFromUserName());
		newsMsg.setCreateTime(baseMsg.getCreateTime());
		newsMsg.setArticleCount(num);
		newsMsg.setMsgType(Constants.MSG_NEWS);
		newsMsg.setArticles(list);
		
		return objMsgToXml(newsMsg);
	}
	
	/*private String locationMsgReplay() {
	LocationMsg locationMsg = new LocationMsg();
	
	locationMsg.setToUserName(toUserName);
	locationMsg.setFromUserName(fromUserName);
	locationMsg.setCreateTime(replayTime);
	locationMsg.setMsgType(Constants.MSG_LOCATION);	
	locationMsg.setLocation_X(reqMap.get("Location_X"));
	locationMsg.setLocation_Y(reqMap.get("Location_Y"));
	locationMsg.setScale(reqMap.get("Scale"));
	locationMsg.setLabel(reqMap.get("Label"));
	
	return MsgUtil.objMsgToXml(locationMsg);
	}*/
	
	/**
	 * 消息对象转为xml
	 */
	private static String objMsgToXml(Object obj) {
		xstream.alias("xml", obj.getClass());
		xstream.processAnnotations(Article.class);
		return xstream.toXML(obj);
	}
	
	/**
	 * 添加CDTATA标记
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				boolean cdata = true;  //可自由设置是否需要添加

				public void startNode(String name) {
					super.startNode(name);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}

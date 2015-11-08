package com.wxcommon.messagemanager;

import java.util.ArrayList;
import java.util.List;

import com.wxcommon.dao.TextMsgDao;
import com.wxcommon.entity.Article;
import com.wxcommon.entity.BaseMsg;
import com.wxcommon.entity.Music;
import com.wxcommon.utils.MsgUtil;
import com.wxcommon.utils.SmallUtils;

public class TextMsgHandler {
	
	/**
	 * 文本消息处理
	 */
	public static String textMsgHandle(String content, BaseMsg baseMsg) {
		String textContent = content.trim();
		String textReplay = "";
		String backReplay = "";
		
		TextMsgDao textMsgDao =new TextMsgDao();
		
		//中英文符号识别
		if(textContent.substring(0, 1).equals("@") || textContent.substring(0,1).equals("@")) {
			List<Object> params = new ArrayList<Object>();
			params.add(baseMsg.getToUserName());
			params.add(SmallUtils.getSendDate());
			params.add(textContent);
			
			boolean flag = textMsgDao.feedBackSave(params);
			if(flag) {
				backReplay = MsgUtil.textMsgReplay("您的意见已于第一时间反馈，感谢参与！", baseMsg);
			}
		}
		
		if(textContent.equals("你好") || textContent.equals("hello")) {
			int hour = Integer.valueOf(SmallUtils.getHour());
			
			if(hour >= 6 && hour <= 8) {
				textReplay = "早上好~";
			}else if(hour >= 9 && hour <= 11) {
				textReplay = "上午好~";
			}else if(hour >= 12 && hour <= 14) {
				textReplay = "中午好~";
			}else if(hour >= 15 && hour <= 17) {
				textReplay = "下午好~";
			}else if(hour >= 18 && hour <= 23) {
				textReplay = "晚上好~";
			}else {
				textReplay = "你好~，现在是睡觉时间/:moon";
			}
			
			backReplay = MsgUtil.textMsgReplay(textReplay, baseMsg);
		}
		
		//QQ表情，原样返回
		String beginString = textContent.substring(0, 1);
		if(beginString.equals("/")) {
			backReplay = MsgUtil.textMsgReplay(textContent, baseMsg);
		}
		
		switch (textContent) {
		case "信敏廉毅":
				backReplay = MsgUtil.textMsgReplay("信而达理，敏而好学，廉而知耻，毅而弥坚/:8-)", baseMsg);
			
			break;
			
		case "再见":
				backReplay = MsgUtil.textMsgReplay("期待再次的见面", baseMsg);
				
			break;
			
		case "美女":
				Article article = new Article();
			
				article.setTitle("美女貂蝉");
				article.setDescription("亲，这位美女可合口味？");
				article.setPicUrl("http://115.29.178.111/WeiXinCommonTest/images/diaochan.jpg");
				article.setUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5OTIxMzQ3Mg==&appmsgid=10000008&itemidx=1&sign=0d5ee89e938d6771a15532caf4e26574#wechat_redirect");

				List<Article> list = new ArrayList<Article>();
				list.add(article);
			
				backReplay = MsgUtil.newsMsgReplay(list, 1, baseMsg);
			break;
		
		case "帅哥":
				backReplay = MsgUtil.textMsgReplay("抱歉，暂无帅哥~", baseMsg);
				
			break;
			
		case "音乐":
				Music music = new Music();
			
				music.setTitle("我好想你-苏打绿");
				music.setDescription("《小时代》主题曲");
				music.setMusicUrl("http://115.29.178.111/WeiXinCommonTest/music/sta.mp3");
				music.setHQMusicUrl("http://115.29.178.111/WeiXinCommonTest/music/stahigh.mp3");
			
				backReplay = MsgUtil.musicMsgReplay(music, baseMsg);
			break;
			
		case "4":
				Article article1 = new Article();
				Article article2 = new Article();
				
				article1.setTitle("番茄时间管理法(Pomodoro Technique)");
				article1.setDescription("如果你经常读一些关于提高工作效率或时间管理类的博客，一定听说过番茄时间管理法(Pomodoro Technique)。这是一种极好的帮助你集中注意力、获得更高工作效率的方法。");
				article1.setPicUrl("http://115.29.178.111/WeiXinCommonTest/images/cxy183.jpg");
				article1.setUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5OTIxMzQ3Mg==&appmsgid=10000012&itemidx=1&sign=3c720ad79691d194ffe536e7c8d2d823#wechat_redirect");

				article2.setTitle("程序员的18个有趣的事实");
				article2.setDescription("1.如果第一次运行不成功，那就叫它1.0版吧。"+"\n" + "2.我的程序永远不会有bug。那些只是开发出来的随机的功能特征。");
				article2.setPicUrl("http://115.29.178.111/WeiXinCommonTest/images/cxy181.jpg");
				article2.setUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5OTIxMzQ3Mg==&appmsgid=10000010&itemidx=1&sign=61d2c77d6b6a8261e4c8ebdcdc2687e1#wechat_redirect");

				List<Article> newsList = new ArrayList<Article>();
				newsList.add(article1);
				newsList.add(article2);
				
				backReplay = MsgUtil.newsMsgReplay(newsList, 2, baseMsg);
			break;
			
		case "0":  //菜单：反馈
				String feedBack = "您的金玉良言将为小贴的成长提供满满正能量！/:,@f" + "\n"
								+ "反馈内容请以@开头，例子如下：" + "\n"
								+ "@意见内容";
				backReplay = MsgUtil.textMsgReplay(feedBack, baseMsg);
			break;
			
		case "菜单":  //菜单导航
				String menu = "回复数字即可进入相应功能:" + "\n"
							+ "1.入学指南" + "\n"
							+ "2.考研指南" + "\n"
							+ "3.就业指南" + "\n"
							+ "4.最新动态" + "\n"
							+ "0.意见反馈" + "\n\n"
							+ "您还希望小贴提供什么服务呢，回复0反馈给我们吧!" + "\n"
							+ "当然也可以加入我们的交流群：276622758，小贴期待您的到来！";
				backReplay = MsgUtil.textMsgReplay(menu, baseMsg);
			break;
			
		case "1":  //入学指南
				String admission = "回复数字选择相应服务:" + "\n"
								 + "11.近五年录取分数线\ue114" + "\n"
								 + "12.到校公交线\ue159" + "\n"
								 + "13.院系简介";
				backReplay = MsgUtil.textMsgReplay(admission, baseMsg);
			break;
		
		case "11": 
				Article proScore = new Article();
				Article speScore = new Article();
			
				proScore.setTitle("江财本省录取分数线");
				proScore.setDescription("");
				proScore.setPicUrl("http://115.29.178.111/WeiXinCommonTest/images/jc_scor.jpg");
				proScore.setUrl("http://115.29.178.111/WeiXinCommonTest/province.jsp");

				speScore.setTitle("江财本省专业分数线");
				speScore.setDescription("");
				speScore.setPicUrl("http://115.29.178.111/WeiXinCommonTest/images/jc_score2.jpg");
				speScore.setUrl("http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5OTIxMzQ3Mg==&appmsgid=10000010&itemidx=1&sign=61d2c77d6b6a8261e4c8ebdcdc2687e1#wechat_redirect");

				List<Article> scoreList = new ArrayList<Article>();
				scoreList.add(proScore);
				scoreList.add(speScore);
				
				backReplay = MsgUtil.newsMsgReplay(scoreList, 2, baseMsg);
			break;
		
		case "2":  //考研指南
				String school = "回复数字选择相应服务:" + "\n"
						      + "21.近五年专业分数线\ue114";
				
				backReplay = MsgUtil.textMsgReplay(school, baseMsg);
		default:
			break;
		}
		
		return backReplay;
	}
}

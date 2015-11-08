package com.wxcommon.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wxcommon.conf.Constants;
import com.wxcommon.entity.BaseMsg;
import com.wxcommon.messagemanager.EventMsgHandler;
import com.wxcommon.messagemanager.ImageMsgHandler;
import com.wxcommon.messagemanager.LocationMsgHandler;
import com.wxcommon.messagemanager.TextMsgHandler;
import com.wxcommon.messagemanager.VoiceMsgHandler;
import com.wxcommon.utils.MsgUtil;
import com.wxcommon.utils.SmallUtils;

/**
 * 返回消息服务类
 * @author lilyth
 *
 */
public class RespMsgService {
	
	public String getRespMsg(HttpServletRequest request) {
		String respMsg = "";
		BaseMsg baseMsg = new BaseMsg();
		
		try {
			Map<String, String> reqMap = MsgUtil.parseReqXml(request);
			
			baseMsg.setFromUserName(reqMap.get("ToUserName")); //公众微信号
			baseMsg.setToUserName(reqMap.get("FromUserName")); //用户微信号
			baseMsg.setCreateTime(SmallUtils.getDate()); //回复时间
			
			switch (reqMap.get("MsgType")) {
			case Constants.MSG_EVENT:
				  	respMsg = EventMsgHandler.eventMsgHandle(reqMap.get(Constants.EVENT_STYLE), baseMsg);
				break;
				
			case Constants.MSG_TEXT:
					respMsg = TextMsgHandler.textMsgHandle(reqMap.get("Content").trim(), baseMsg);;
				break;
				
			case Constants.MSG_IMAGE:
					respMsg = ImageMsgHandler.imageMsgHandle(baseMsg);
				break;
				
			case Constants.MSG_VOICE:
					respMsg = VoiceMsgHandler.voiceHandle(reqMap, baseMsg);
				break;
			
			case Constants.MSG_LOCATION:
					respMsg = LocationMsgHandler.locationHandle(reqMap, baseMsg);
				break;
				
			default:
				break;
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		if(respMsg.equals("")) {
			return MsgUtil.textMsgReplay("请回复“菜单”进入帮助导航", baseMsg);
		}else {
			return respMsg;
		}
	}

}

package com.wxcommon.messagemanager;

import com.wxcommon.conf.Constants;
import com.wxcommon.entity.BaseMsg;
import com.wxcommon.utils.MsgUtil;

public class EventMsgHandler {

	/**
	 * 事件推送消息处理
	 */
	public static String eventMsgHandle(String event, BaseMsg baseMsg) {
		String eventReplay = "";
		if(event.equals(Constants.EVENT_SUBSCRIBE)) {
			String content = "感谢您的关注，贴兄正在路上!/:,@f";
			eventReplay = MsgUtil.textMsgReplay(content, baseMsg);
		}else if(event.equals(Constants.EVENT_UNSUBSCRIBE)) {
		//	String content = "欢迎下次再来，贴兄目送!/:8*";
		//	eventReplay = textMsgReplay(content);
		}
		
		return eventReplay;
	}
}

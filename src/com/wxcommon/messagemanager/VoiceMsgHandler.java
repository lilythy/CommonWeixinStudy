package com.wxcommon.messagemanager;

import java.util.Map;

import com.wxcommon.entity.BaseMsg;
import com.wxcommon.utils.MsgUtil;

public class VoiceMsgHandler {
	
	/**
	 * 语音消息处理
	 */
	public static String voiceHandle(Map<String, String> reqMap, BaseMsg baseMsg) {
		String voiceReplay = "你的声音很好听~";
	//	String voiceReplay = reqMap.get("Recognition");
		
		return MsgUtil.textMsgReplay(voiceReplay, baseMsg);
	}
}

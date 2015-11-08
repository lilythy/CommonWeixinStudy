package com.wxcommon.messagemanager;

import java.util.Map;

import com.wxcommon.entity.BaseMsg;
import com.wxcommon.utils.MsgUtil;

public class LocationMsgHandler {
	
	/**
	 * 位置消息处理
	 * @return
	 */
	public static String locationHandle(Map<String, String> reqMap, BaseMsg baseMsg) {
		String locationReplay = "经度:"+ reqMap.get("Location_X") + "\n" 
							  + "纬度" + reqMap.get("Location_Y") + "\n"
							  + "地址:" + reqMap.get("Label");
		
		return MsgUtil.textMsgReplay(locationReplay, baseMsg);
	}

}

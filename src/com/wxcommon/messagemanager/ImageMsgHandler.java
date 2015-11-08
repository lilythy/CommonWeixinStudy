package com.wxcommon.messagemanager;

import com.wxcommon.entity.BaseMsg;
import com.wxcommon.utils.MsgUtil;

public class ImageMsgHandler {

	/**
	 * 图片消息处理
	 */
	public static String imageMsgHandle(BaseMsg baseMsg) {
		String imageReplay = "你发的这张图片好漂亮哦！";
		
		return MsgUtil.textMsgReplay(imageReplay, baseMsg);
	}
}

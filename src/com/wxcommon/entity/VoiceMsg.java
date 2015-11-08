package com.wxcommon.entity;

/**
 * 语音消息
 * @author lilyth
 * Created at 2013-11-16
 */
public class VoiceMsg extends BaseMsg{
	/**
	 * 语音id
	 */
	private String MediaId;
//	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}

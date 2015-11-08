package com.wxcommon.conf;


/**
 * @author lilyth
 * Created at 2013-11-16
 */
public class Constants {
	
	//微信验证
	public static final int DEVELOP_CHECK = 0; //申请开发模式验证
	public static final int MSG_CHECK = 1; //微信消息来源验证

	//消息类型
	public static final String MSG_TEXT = "text"; //文本
	public static final String MSG_IMAGE = "image"; //图片
	public static final String MSG_VOICE = "voice"; //语音
	public static final String MSG_MUSIC = "music"; //音乐
	public static final String MSG_NEWS = "news"; //图文
	public static final String MSG_Link = "link"; //链接
	public static final String MSG_LOCATION = "location"; //位置信息
	
	//事件类型
	public static final String MSG_EVENT = "event"; //事件推送
	public static final String EVENT_STYLE = "Event"; //事件类型
	public static final String EVENT_LOCATION = "LOCATION"; //位置事件
	public static final String EVENT_SUBSCRIBE = "subscribe"; //关注
	public static final String EVENT_UNSUBSCRIBE = "unsubscribe"; //取消关注
	
	
}

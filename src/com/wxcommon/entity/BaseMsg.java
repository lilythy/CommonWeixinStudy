package com.wxcommon.entity;

/**
 * @author lilyth
 * Created at 2013-11-16
 */
public class BaseMsg {
	private String ToUserName; //公众微信号
	private String FromUserName; //用户微信号
	private String CreateTime; //生成时间
	private String MsgType; //消息类型
	
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
}

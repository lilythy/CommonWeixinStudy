package com.wxcommon.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图文item类
 * @author lilyth
 * Created at 2013-11-16
 */
@XStreamAlias("item")
public class Article {
	/**
	 * 标题
	 */
	private String Title;
	/**
	 * 摘要
	 */
	private String Description;
	/**
	 * 图片地址
	 */
	private String PicUrl;
	/**
	 * 原文地址
	 */
	private String Url;
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
}

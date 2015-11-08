package com.wxcommon.entity;

import java.util.List;

/**
 * 图文信息类
 * @author lilyth
 * Created at 2013-11-16
 */
public class NewsMsg extends BaseMsg {
	/**
	 * 图文个数，10条以内
	 */
	private int ArticleCount;
	/**
	 * 图文item集合，默认第一个为大图
	 */
	private List<Article> Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
	
	
}

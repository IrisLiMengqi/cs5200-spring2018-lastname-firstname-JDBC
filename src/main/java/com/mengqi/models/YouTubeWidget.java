package com.mengqi.models;

public class YouTubeWidget extends Widget{
	private int id;
	private String url;
	private boolean shareble;
	private boolean expandable;
	private Widget widget;
	public YouTubeWidget() {
		super();
	}
	public YouTubeWidget(int id, String name, String text, int order, int width, int height, String url, boolean shareble, boolean expandable) {
		super(name, text, order, width, height);
		this.id = id;
		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareble() {
		return shareble;
	}
	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}

}

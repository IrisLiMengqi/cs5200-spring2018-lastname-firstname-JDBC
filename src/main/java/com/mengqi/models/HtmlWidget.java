package com.mengqi.models;

public class HtmlWidget extends Widget{
	private int id;
	private String html;
	public HtmlWidget() {
		super();
	}
	public HtmlWidget(int id, String name, String text, int order, int width, int height, String html) {
		super(name, text, order, width, height);
		this.id = id;
		this.html = html;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}

	

}

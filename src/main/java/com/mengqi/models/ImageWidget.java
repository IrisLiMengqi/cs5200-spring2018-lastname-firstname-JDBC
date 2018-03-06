package com.mengqi.models;

public class ImageWidget extends Widget{
	private int id;
	private String src;
	public ImageWidget() {
		super();
	}
	public ImageWidget(int id, String name, String text, int order, int width, int height, String src) {
		super(name, text, order, width, height);
		this.id = id;
		this.src = src;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
}

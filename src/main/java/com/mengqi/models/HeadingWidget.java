package com.mengqi.models;

public class HeadingWidget extends Widget{
	private int id;
	private int size;
	public HeadingWidget() {
		super();
	}
	public HeadingWidget(int id, String name, String text, int order, int width, int height, int size) {
		super(name, text, order, width, height);
		this.id = id;
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}

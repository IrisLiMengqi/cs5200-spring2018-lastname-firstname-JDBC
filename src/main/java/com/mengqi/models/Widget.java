package com.mengqi.models;

import java.util.Collection;

public class Widget {
	private int id;
	private String name;
	private String text;
	private String cssClass;
	private String sccStyle;
	private int order;
	private int width;
	private int height;
	
	

	public Widget() {
		super();
	}
	public Widget(String name, String text, int order, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.text = text;
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getSccStyle() {
		return sccStyle;
	}
	public void setSccStyle(String sccStyle) {
		this.sccStyle = sccStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}
	
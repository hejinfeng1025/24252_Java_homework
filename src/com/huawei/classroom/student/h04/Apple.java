package com.huawei.classroom.student.h04;

public class Apple {
	private String color;
	private int size;
	//无参构造函数
	public Apple() {
		this.color="red";
		this.size=0;
	}
	//有参构造函数
	public Apple(int size, String color) {
		this.color=color;
		this.size=size;
	}
	public String getColor() {
		return color;
	}
	public int getSize() {
		return size;
	}

}

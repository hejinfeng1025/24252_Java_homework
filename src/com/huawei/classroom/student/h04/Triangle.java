package com.huawei.classroom.student.h04;

public class Triangle {
	public Triangle() {
		
	}
	private double a,b,c;
	public void setA(double len){
		this.a=len;
	}
	public void setB(double len){
		this.b=len;
	}
	public void setC(double len){
		this.c=len;
	}
	public double getArea() {
		double p=(a+b+c)/2.0;
		double area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
	}
}

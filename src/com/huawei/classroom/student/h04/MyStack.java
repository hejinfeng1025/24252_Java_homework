package com.huawei.classroom.student.h04;

public class MyStack {
	private int size;
	private int[] sta;
	private int top;
	public MyStack(int size) {
		this.size=size;
		this.sta=new int[this.size];
		this.top=0;
	}
	int pop() {
		if(this.top==0) {
			return 0;
		}
		else {
			top--;
			return this.sta[top];
		}
	}
	void push(int e) {
		if(this.top==this.size) {
			return;
		}
		this.sta[top]=e;
		this.top++;
	}
	boolean isEmpty() {
		if(this.top==0)
			return true;
		return false;
	}
	boolean isFull() {
		if(this.top==size){
			return true;
		}
		return false;
	}
}

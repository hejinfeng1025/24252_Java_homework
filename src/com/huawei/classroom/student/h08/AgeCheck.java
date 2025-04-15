package com.huawei.classroom.student.h08;

public class AgeCheck implements AgeCheckInterface{
	public void checkAge(int age) {
		// 当checkAge中的参数<0或者>200的时候抛出异常，
		if(age>200||age<0) {
			throw new RuntimeException();
		}
		
	}
}

package com.huawei.classroom.student.h08;

public class TypeValidator {

	public void validate(Object a) {
		if(a instanceof String) {
			return;
		}
		else {
			throw new RuntimeException();
		}
	}
}

package com.huawei.classroom.student.h06;

public class Barrack extends Building{
	public Barrack(int x,int y) {
		super(Param.BARRACK_LV,Param.BARRACK_AP,Param.BARRACK_AR,x,y);
	}
	public Base traing(EnumObjectType type) {
		if(type==EnumObjectType.rifleSoldier) {
			return new RifleSoldier(this.getX(),this.getY());
		}
		if(type==EnumObjectType.RPGSoldier) {
			return new RPGSoldier(this.getX(),this.getY());
		}
		if(type==EnumObjectType.dog) {
			return new Dog(this.getX(),this.getY());
		}
		else
			return null;
	}
	
}

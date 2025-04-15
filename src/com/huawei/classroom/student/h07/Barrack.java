package com.huawei.classroom.student.h07;

public class Barrack extends Building {

	public Barrack(int x, int y) {
		super(100,0,0,x,y);
		// super( Param.BARRACK_HEALTH,Param.BARRACK_STRENGTH);
		// TODO Auto-generated constructor stub
	}

	public GameObject traing(EnumObjectType type) {
		if (type == EnumObjectType.rifleSoldier) {
			return new RifleSoldier(this.getX(),this.getY());
		} else if (type == EnumObjectType.RPGSoldier) {
			return new RPGSoldier(this.getX(),this.getY());
		} else if (type == EnumObjectType.dog) {
			return new Dog(this.getX(),this.getY());
		}
		else
			return null;
	}

}

package com.huawei.classroom.student.h06;

public class MediumTank extends Tank implements Attack{
	public MediumTank(int x, int y) {
		super(Param.TANK_MEDIUM_LV, Param.TANK_MEDIUM_AP, Param.TANK_AR, x, y);
	}
	@Override
	public void attack(Base other) {
		if(this.getstance(other)<=Param.TANK_AR) {
			other.setHealthPoints(Param.TANK_MEDIUM_AP);
		}
	}
}

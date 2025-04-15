package com.huawei.classroom.student.h06;

public class HeavyTank extends Tank implements Attack{
	public HeavyTank(int x, int y) {
		super(Param.TANK_HEAVY_LV, Param.TANK_HEAVY_AP, Param.TANK_AR, x, y);
	}

	@Override
	public void attack(Base other) {
		if(this.getstance(other)<=Param.TANK_AR) {
			other.setHealthPoints(Param.TANK_HEAVY_AP);
		}
	}
	
}

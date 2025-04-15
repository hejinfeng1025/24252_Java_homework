package com.huawei.classroom.student.h06;

public class RPGSoldier extends Soldier implements Attack{
	public RPGSoldier(int x,int y) {
		super(Param.SOLDIER_LV,Param.SOLDIER_RPG_AP,
				Param.SOLDIER_RPG_AR,x,y);
	}
	@Override
	public void attack(Base other) {
		if(this.getstance(other)<=Param.SOLDIER_RPG_AR) {
			other.setHealthPoints(Param.SOLDIER_RPG_AP);
		}
		
	}
}

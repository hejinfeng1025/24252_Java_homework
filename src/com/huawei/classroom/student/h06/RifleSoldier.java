package com.huawei.classroom.student.h06;

public class RifleSoldier extends Soldier implements Attack{
	public RifleSoldier(int x,int y) {
		super(Param.SOLDIER_LV,Param.SOLDIER_RIFLE_AP,
				Param.SOLDIER_RIFLE_AR,x,y);
	}

	@Override
	public void attack(Base other) {
		if(this.getstance(other)<=Param.SOLDIER_RIFLE_AR) {
			if(other instanceof Dog) {
				if(other.getHealthPoints()<0) {
					return;
				}
				other.setHealthPoints(Param.DOG_LV);
			}
			else {
						other.setHealthPoints(Param.SOLDIER_RIFLE_AP);	
			}
		}
		
	}
	
}

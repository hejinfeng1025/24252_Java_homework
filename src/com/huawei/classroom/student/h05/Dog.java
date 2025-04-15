package com.huawei.classroom.student.h05;

public class Dog extends Base{
	////Dog 军犬 ,初始生命值50，攻击力5(对战人类时候一口毙命)
	Dog(){
		super(50,5);
	}
	public void attack(Soldier s1) {
		if(s1.healthPoints>0) {
			s1.healthPoints=0;
			Soldier.setDeadedSoldier();
		}
	}
}

package com.huawei.classroom.student.h05;

public class RifleSoldier extends Soldier{
	//步枪兵  初始生命值50(对战 军犬除外)，攻击力 5（对战军犬可以一次击毙军犬)
	public RifleSoldier() {
		super(50,5);
	}
	public void attack(Dog d1){
		if(d1.healthPoints>0) {
		d1.healthPoints=0;
	}
}
}

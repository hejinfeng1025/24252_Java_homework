package com.huawei.classroom.student.h05;

public class Barrack extends Base {
	//兵营，可以训练出步枪兵、 RPG兵、军犬,初始生命值100，无攻击力
	public Barrack() {
		super(100,0);
	}
	public Base traing(EnumObjectType trained) {
		if(trained==EnumObjectType.rifleSoldier) {
			//步枪兵  初始生命值50(对战 军犬除外)，攻击力 5（对战军犬可以一次击毙军犬)
			return new RifleSoldier();
		}
		if(trained==EnumObjectType.RPGSoldier) {
			//火箭兵  初始生命值50(对战 军犬除外)，攻击力 10 
			return new RPGSoldier();
		}
		if(trained==EnumObjectType.dog) {
			//军犬 ,初始生命值50，攻击力5(对战人类时候一口毙命)
			return new Dog();
		}
		else
			return null;
	}
}

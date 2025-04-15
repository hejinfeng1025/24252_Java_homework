package com.huawei.classroom.student.h05;

public class WarFactory extends Base{
//兵工厂,初始生命值100，无攻击力  
	public WarFactory(){
		super(100,0);
	}
	//building 建造各自型号坦克
	public Tank building(EnumObjectType built) {
		if(built==EnumObjectType.heavyTank) {
			return new HeavyTank();
		}
		if(built==EnumObjectType.mediumTank) {
			return new MediumTank();
		}
		else
			return null;
	}
}

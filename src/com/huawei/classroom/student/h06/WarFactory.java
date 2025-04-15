package com.huawei.classroom.student.h06;

public class WarFactory extends Building{
	public WarFactory(int x,int y) {
		super(Param.WAR_FACTORY_LV,Param.WAR_FACTORY_AP,Param.WAR_FACTORY_AR,x,y);
	}
	public Tank building(EnumObjectType type) {
		if(type==EnumObjectType.mediumTank) {
			return new MediumTank(this.getX(),this.getY());
		}
		if(type==EnumObjectType.heavyTank ) {
			return new HeavyTank(this.getX(),this.getY());
		}
		else
			return null;
	};
}

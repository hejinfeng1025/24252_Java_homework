package com.huawei.classroom.student.h06;

public class GameBase extends Building{
	public GameBase(int x,int y){
		super(Param.BASE_LV, Param.BASE_AP, Param.BASE_AR, x, y);	
	}
	
	public static GameBase createGameBase(int x,int y){
		GameBase gb=new GameBase(x,y);
		return gb;
	}
	
	public Building building(EnumObjectType type,int x,int y) {
		if(type==EnumObjectType.barrack) {
			return new Barrack(x,y);
		}
		if(type==EnumObjectType.warFactory) {
			return new WarFactory(x,y);
		}
		else
			return null;
	}
	
	
	
	
}

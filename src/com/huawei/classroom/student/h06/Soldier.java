package com.huawei.classroom.student.h06;

public class Soldier extends Base{
	private static int livingSoldierCount=0;
	private static int deadedSoldierCount=0;

	public Soldier(int hp,int atk,double atr,int x,int y) {
		super(hp,atk,atr,x,y);
		setLivingSoldierCount();
	}

	public static void setLivingSoldierCount() {
		livingSoldierCount++;
	}

	public static void setDeadedSoldierCount() {
		livingSoldierCount--;
		deadedSoldierCount++;
	}

	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}

	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	@Override
	public void dead() {
		setDeadedSoldierCount();
	}
	
}

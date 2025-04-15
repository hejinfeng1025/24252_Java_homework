package com.huawei.classroom.student.h07;

public abstract class Soldier extends GameObject {

	private static int livingSoldierCount = 0;
	private static int deadedSoldierCount = 0;

	public Soldier(int hp,int atk,int atr,int x,int y) {
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

	

	

	
}

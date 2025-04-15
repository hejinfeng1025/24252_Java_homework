package com.huawei.classroom.student.h05;

public class Soldier extends Base{
//统计现在有多少个活着的和死去的士兵数量
	private static int livingSoldiernum;//活着的士兵数量
	private static int deadedSoldiernum;//死去的士兵数量
	public Soldier(int hp,int stk) {
		super(hp,stk);
		setLivingSoldier();
	}
	public static void setLivingSoldier() {
		livingSoldiernum++;
	}
	public static void setDeadedSoldier() {
		livingSoldiernum--;
		deadedSoldiernum++;
	}
	public static int getLivingSoldierCount() {
		return livingSoldiernum;
	}
	public static int getDeadedSoldierCount() {
		return deadedSoldiernum;
	}
	
}

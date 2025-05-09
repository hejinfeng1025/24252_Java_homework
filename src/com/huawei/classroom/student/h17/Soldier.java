package com.huawei.classroom.student.h17;


/**
 * @author super
 */
public abstract class Soldier extends GameObject {

	private static int livingSoldierCount=0;
	private static int deadedSoldierCount=0;
	
	public Soldier(Player player, int lv,int ap, double ar, int x, int y) {
		super(player, lv, ap, ar, x, y);
		livingSoldierCount++;
	}
	public static int getLivingSoldierCount() {
		return livingSoldierCount;
	}
	public static int getDeadedSoldierCount() {
		return deadedSoldierCount;
	}

	@Override
	public void dead() {
		livingSoldierCount--;
		deadedSoldierCount++;
	}
 

}

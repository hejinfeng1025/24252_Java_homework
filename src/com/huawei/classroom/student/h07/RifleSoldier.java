package com.huawei.classroom.student.h07;

public class RifleSoldier extends Soldier {

	public RifleSoldier(int x,int y) {
		super(50,5,5,x,y);
	}
	@Override
	public void attack(GameObject obj) {
		int dx = this.getX() - obj.getX();
		int dy = this.getY() - obj.getY();
		double dis = Math.pow(dx * dx + dy * dy, 0.5);
		
		if (this.getRange() < dis) {
			return;
		}
		if (obj instanceof Dog) {
			obj.setHealth(0);
		} else {
			obj.setHealth(obj.getHealth() - this.getStrength());
		}
	}
	

}

package com.huawei.classroom.student.h07;


public class Dog extends GameObject {

	public Dog(int x,int y) {
		super(50,5,5,x,y);
		// super( Param.DOG_HEALTH,Param.DOG_STRENGTH);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack(GameObject obj) {
		if(obj.getHealth()<=0) {
			return;
		}
		else {
			int dx = this.getX() - obj.getX();
			int dy = this.getY() - obj.getY();
			double dis = Math.pow(dx * dx + dy * dy, 0.5);
			if (this.getRange() < dis) {
				return;
			}
			else {
				if(obj instanceof Soldier) {
					obj.setHealth(0);
					Soldier.setDeadedSoldierCount();
				}
				else {
				obj.setHealth(obj.getHealth() - this.getStrength());
				}
			}
		}
	}


}

package com.huawei.classroom.student.h06;

public class Dog extends Training implements Attack{
	public Dog(int x,int y) {
		super(Param.DOG_LV,Param.DOG_AP,Param.DOG_AR,x,y);
	}

	@Override
	public void attack(Base obj) {
		if(obj.getHealth()<=0) {
			return;
		}
		else {
			int dx = this.getX() - obj.getX();
			int dy = this.getY() - obj.getY();
			double dis = Math.pow(dx * dx + dy * dy, 0.5);
			if (Param.DOG_AR < dis) {
				return;
			}
			else {
				if(obj instanceof Soldier) {
					obj.setHealthPoints(50);
					System.out.println("狗咬人啦！！！");
				}
				else {
				obj.setHealthPoints(Param.DOG_AP);
				}
			}
		}
	}
	
}

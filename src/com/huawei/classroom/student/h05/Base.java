package com.huawei.classroom.student.h05;

public class Base {
	protected int healthPoints;//生命值hp
	protected int attackValue;//攻击力atk
	public Base(int hp,int atk){
		this.healthPoints=hp;
		this.attackValue=atk;
	}
	public int getHealth() {
		//返回当前生命值，如果已经死亡则返回 <=0的一个数字
		return this.healthPoints;
	}
	public boolean isDestroyed() {
		//如果生命值<=0则true,否则false
		if(this.healthPoints<=0)
			return true;
		return false;
	}
	public void attack(Dog dog) {
		//军犬被攻击
		if(dog.healthPoints>0){
			dog.healthPoints-=this.attackValue;
		}
	}
	public void attack(Tank tank) {
		//坦克被攻击
		if(tank.healthPoints>0){
			tank.healthPoints-=this.attackValue;
		}
	}
	public void attack(Soldier soldier) {
		//士兵被攻击
		if(soldier.healthPoints>0){
			soldier.healthPoints-=this.attackValue;
		}
		if(soldier.healthPoints<=0) {
			Soldier.setDeadedSoldier();
		}
	}
	
	
	
}

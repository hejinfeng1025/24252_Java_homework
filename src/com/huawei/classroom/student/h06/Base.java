package com.huawei.classroom.student.h06;

public class Base {
	private int healthPoints;//生命值hp
	private final int attackValue;//攻击力atk
	private final double attackRange;//攻击范围atr
	private int x;//横坐标
	private int y;//纵坐标
	
	public Base(int hp,int atk,double atr,int x,int y) {
		this.healthPoints=hp;
		this.attackValue=atk;
		this.attackRange=atr;
		this.x=x;
		this.y=y;
	}
	

	public int getHealthPoints() {
		return healthPoints;
	}


	public void setHealthPoints(int strength) {
		if(isDestroyed()) {
			return;
	}
	else {
		this.healthPoints-=strength;
	}
		if(this.healthPoints<=0) {
			this.dead();
		}
}
	public void dead() {

	}

	public int getAttackValue() {
		return attackValue;
	}


	public double getAttackRange() {
		return attackRange;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHealth() {
		//返回当前生命值，如果已经死亡则返回 <=0的一个数字
		return this.healthPoints;
	}
	public boolean isDestroyed() {
		//如果生命值<=0则true,否则false
		if(this.healthPoints>0)
			return false;
		else
			return true;
	}
	public double getstance(Base other) {
		return Math.sqrt((other.x-this.x)*(other.x-this.x)+(other.y-this.y)*(other.y-this.y));
	}
	public void move(int dx,int dy) {
		this.x += dx;
		this.y += dy;
	}
}

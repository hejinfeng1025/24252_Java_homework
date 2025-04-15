package com.huawei.classroom.student.h07;

public abstract class GameObject {
	private int range;
	private int x;
	private int strength;

	private int y;

	private int health = 0;

	private int defaultStrength;

	public GameObject() {
		
	}
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public GameObject(int hp,int atk,int atr,int x,int y) {
		this.health=hp;
		this.strength=atk;
		this.range=atr;
		this.x=x;
		this.y=y;
	}

	public void attack(GameObject obj) {
		if(obj.getHealth()<=0) {
			return;
		}
		else {
			int dx = this.x - obj.x;
			int dy = this.y - obj.y;
			double dis = Math.pow(dx * dx + dy * dy, 0.5);
			if (this.range < dis) {
				return;
			}
			obj.health = obj.health - this.strength;
			
			if(obj instanceof Soldier) {
				if (obj.getHealth() <= 0) {
					Soldier.setDeadedSoldierCount();
				}
			}
		}
	}


	public void changeHealth(int strength) {
		int beforeHealth = this.getHealth();
		this.health = this.health - strength;
		if (beforeHealth > 0 && this.health <= 0) {
			this.dead();
		}
	}

	public void dead() {

	}

	public boolean isDestroyed() {
		return health <= 0;
	}

	public void move(int dx, int dy) {
		this.x = this.x + dx;
		this.y = this.y + dy;
	}

	
	
	
	public void setHealth(int health) {
		this.health = health;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getHealth() {
		return health;
	}
	public int getRange() {
		return range;
	}
	public int getStrength() {
		return strength;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getDefaultStrength() {
		return defaultStrength;
	}

	public void setDefaultStrength(int defaultStrength) {
		this.defaultStrength = defaultStrength;
	}
	
}

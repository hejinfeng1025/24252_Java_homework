package com.huawei.classroom.student.h08;

public class Bank {
	private int moneyNow;

	public int getMoneyNow() {
		return moneyNow;
	}

	public void setMoneyNow(int moneyNow) {
		this.moneyNow = moneyNow;
	}
	public void save(int m) {
		moneyNow+=m;
	}
	public void get(int m) throws NoMoneyException {
		if(moneyNow>m) {
			moneyNow-=m;
		}
		else
			throw new NoMoneyException("余额不足啦傻货！");
	}
	
}

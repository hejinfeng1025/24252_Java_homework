package com.huawei.classroom.student.h52;

/**
 * @author hejinfeng
 * @create 2025-06-09 11:33
 */
public class Rabbit {
    private int rabbitAge;
    public int livingMax = 700; // 兔子寿命
    private boolean dead; // 是否死亡
    private int day1 = 180; // 第一天繁殖时间
    private int day2 = 90; // 后续繁殖间隔

    public Rabbit() {
        this.rabbitAge = 0;
        this.dead = false;
    }

    public void growOneDay() {
        if(isdead()){
            return;
        }
        rabbitAge++;
        if(rabbitAge > livingMax) {
            dead = true;
        }

    }

    public int getRabbitAge() {
        return rabbitAge;
    }

    public void setRabbitAge(int rabbitAge) {
        this.rabbitAge = rabbitAge;
    }

    public boolean isdead() {
        return dead;
    }

}

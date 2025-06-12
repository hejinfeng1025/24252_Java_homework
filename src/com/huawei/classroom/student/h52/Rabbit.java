package com.huawei.classroom.student.h52;

/**
 * 兔子类，表示一只兔子的生命周期和状态
 * @author hejinfeng
 * @create 2025-06-09 11:33
 */
public class Rabbit {
    private int rabbitAge; // 兔子的当前年龄（天）
    public int livingMax = 700; // 兔子寿命（天）
    private boolean dead; // 标记兔子是否死亡
    private int day1 = 180; // 第一次繁殖的天数
    private int day2 = 90; // 后续每次繁殖的间隔天数

    public Rabbit() {
        this.rabbitAge = 0;
        this.dead = false;
    }

    public void growOneDay() {
        if(isdead()){
            return; // 死亡兔子不再成长
        }
        rabbitAge++;
        if(rabbitAge > livingMax) {
            dead = true; // 超过寿命则死亡
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

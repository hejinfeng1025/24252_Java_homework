package com.huawei.classroom.student.h52;

import java.util.*;

/**
 * 兔子窝类，管理所有兔子的生命周期和繁殖
 * @author hejinfeng
 * @create 2025-06-09 11:31
 */
public class RabbitNest {
    private List<Rabbit> rabbitList = new ArrayList<>(); // 存放所有兔子的列表

    /**
     * 构造函数，初始化兔子窝，添加初始数量的兔子
     * @param startCount 初始兔子对数
     */
    public RabbitNest(int startCount){//构造函数，初始化兔子窝
        for(int i = 0;i<startCount;i++){
            Rabbit r = new Rabbit();
            rabbitList.add(r);
        }
    }

    public void oneDayPass() {
        rabbitsGrow(); // 兔子成长
        rabbitsDead(); // 死亡兔子移除
        rabbitsBearLittleRabbits(); // 存活兔子繁殖
    }

    public void rabbitsGrow() {
        for(Rabbit r : rabbitList){
            r.growOneDay();
        }
    }

    public void rabbitsDead() {
        rabbitList.removeIf(Rabbit::isdead);
    }

    public void  rabbitsBearLittleRabbits(){
        List<Rabbit> aliveRabbits = new ArrayList<>();
        for(Rabbit r:rabbitList){
            if(r.isdead()){
                continue; // 死亡兔子不繁殖
            }
            if(r.getRabbitAge()<180){
                continue; // 未到首次繁殖年龄
            }
            // 满180天首次繁殖，之后每隔90天繁殖
            if(r.getRabbitAge() == 180 ||(r.getRabbitAge()-180) % 90 == 0){
                Rabbit r2 = new Rabbit();
                Rabbit r3 = new Rabbit();
                aliveRabbits.add(r2);
                aliveRabbits.add(r3);
            }
        }
        rabbitList.addAll(aliveRabbits); // 添加新出生的兔子
    }

    public int getLivingRabbits() {
        return rabbitList.size();
    }
}

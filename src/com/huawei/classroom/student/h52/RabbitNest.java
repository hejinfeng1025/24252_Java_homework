package com.huawei.classroom.student.h52;

import java.util.*;

/**
 * @author hejinfeng
 * @create 2025-06-09 11:31
 */
public class RabbitNest {
    private List<Rabbit> rabbitList = new ArrayList<>();
    public RabbitNest(int startCount){//构造函数，初始化兔子窝
        for(int i = 0;i<startCount;i++){
            Rabbit r = new Rabbit();
            rabbitList.add(r);
        }
    }
    public void oneDayPass() {
        rabbitsGrow();
        rabbitsDead();
        rabbitsBearLittleRabbits();
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
                continue;
            }
            if(r.getRabbitAge()<180){
                continue;
            }
            if(r.getRabbitAge() == 180 ||(r.getRabbitAge()-180) % 90 == 0){
                Rabbit r2 = new Rabbit();
                Rabbit r3 = new Rabbit();
                aliveRabbits.add(r2);
                aliveRabbits.add(r3);
            }
        }
        rabbitList.addAll(aliveRabbits);
    }
    public int getLivingRabbits() {
        return rabbitList.size();
    }
}

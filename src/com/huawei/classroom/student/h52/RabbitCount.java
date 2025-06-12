/**
 * 
 */
package com.huawei.classroom.student.h52;

/**
 * 兔子数量统计类，计算经过若干天后存活的兔子对数
 * @author Administrator
 *
 */
public class RabbitCount {

	/**
	 * 1对兔子出生以后经过180天可以生出一窝（2对）兔子，以后每隔90天繁殖一次生出一窝（2对）兔子
	 * 每对兔子的寿命是700天 
	 * @param startCount 第0天 开始的时候初生的兔子对数
	 * @param days 经过的天份数
	 * @return 目前系统中存活的兔子的对数
	 * 初始startCount对兔子，经过days天以后，会有多少对存活的兔子
	 */
	public int getLivingRabbit(int startCount,int days) {
		int result = startCount;
		if(days<180){
			result = startCount; // 180天内不会繁殖，数量不变
		}
		RabbitNest nest = new RabbitNest(startCount); // 创建兔子窝
		for(int i = 0;i<days;i++){
			nest.oneDayPass(); // 每天模拟兔子成长、死亡、繁殖
		}
		result = nest.getLivingRabbits(); // 获取存活兔子数量
		return result;
	}
}

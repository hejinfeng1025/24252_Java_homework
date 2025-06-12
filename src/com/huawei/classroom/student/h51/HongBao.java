package com.huawei.classroom.student.h51;

import java.util.*;

public class HongBao {

	/**
	 * 微信红包分配算法
	 * @param total  红包总金额，以元为单位，精确到分，系统测试的时候保证总金额至少够每人分得1分钱
	 * @param personCount 分红包的总人数>0
	 * @return 每个人分得的钱数数组
	 * 规则：
	 * 1. 每人分得的钱数总和=total
	 * 2. 每个人分得钱数必须是正数，且不能少于1分
	 */
	public double[] getHongbao(double total,int personCount) {
		double result[]=new double[personCount]; // 存储每个人分得的金额
		if(total <personCount*0.01){// 如果总金额不足以保证每人至少1分，返回null
			return null;
		}
		for(int i=0;i<personCount;i++){
			int remainPerson = personCount - i; // 剩余未分配人数
			// 获取当前这个人分得的金额
			result[i] = getOneRedPackage(total, remainPerson);
			// 从总金额中减去已分配的金额
			total -= result[i];
		}
		return result;
	}

	/**
	 * 计算单个红包金额
	 * @param remainMoney 剩余可分配的金额
	 * @param remainPerson 剩余未分配人数
	 * @return 当前红包金额
	 */
	public double getOneRedPackage(double remainMoney, int remainPerson) {
		// 最小分红包金额为0.01元
		double result = 0.01;
		double min = 0.01;
		// 最大可分配金额，保证剩下的人每人至少1分
		double max1 = remainMoney - remainPerson*0.01;
		Random random = new Random();
		if(remainPerson == 1){// 最后一个人，直接分配剩余所有金额
			result = remainMoney;
		}
		else{
			// 随机分配金额，范围[min, max1]
			// Math.random()返回[0.0, 1.0)，乘以max1得到[0, max1)
			result = Math.random() * max1;
			// 保证金额不少于最小值
			result = Math.max(result,min);
		}
		// 保留两位小数，四舍五入
		result =(double) Math.round(result * 100) / 100;

		return result;
	}

}

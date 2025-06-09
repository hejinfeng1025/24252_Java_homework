package com.huawei.classroom.student.h51;

import java.util.*;

public class HongBao {

	/**
	 * 
	 * @param total  红包总金额，以元为单位，精确到分，系统测试的时候保证总金额至少够每人分得1分钱
	 * @param personCount 分红包的总人数>0
	 * @return 每个人分得的钱数
	 * 规则遵循微信分红包规则 例如：
	 * 要求 每人分得的钱数总和=total
	 * 每个人分得钱数必须是正数，且不能少于1分
	 * 
	 */
	public double[] getHongbao(double total,int personCount) {
		double result[]=new double[personCount];
		if(total <personCount*0.01){
			return null;
		}
		for(int i=0;i<personCount;i++){
			int remainPerson = personCount - i;
			result[i] = getOneRedPackage(total, remainPerson);
			total -= result[i];

		}
		return result;
	}
	public double getOneRedPackage(double remainMoney, int remainPerson) {
		// 最小分红包金额为0.01元
		double result = 0.01;
		double min = 0.01;
		double max1 = remainMoney - remainPerson*0.01;
		Random random = new Random();
		if(remainPerson == 1){
			result = remainMoney;
		}
		else{
			//Math.random()方法会返回一个[0.0, 1.0)范围内的伪随机双精度浮点数（包含0.0但不包含1.0）。
			// 将这个随机数乘以max值后，得到的结果是一个[0, max)范围内的随机数。
			result = Math.random() * max1;
			result = Math.max(result,min);
		}
		result =(double) Math.round(result * 100) / 100;

		return result;
	}



}



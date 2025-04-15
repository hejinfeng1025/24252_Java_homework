package com.huawei.classroom.student.h03;

import java.math.BigInteger;
import java.util.Arrays;
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//isNarcissisticNum 测试用例
		if(!Home03.isNarcissisticNum(3)) {
			System.out.println("isNarcissisticNum 测试用1通过");
		}
		if(Home03.isNarcissisticNum(153)) {
			System.out.println("isNarcissisticNum测试用2通过");
		}
		
		//Perfectnumber 测试用例
		if(Home03.Perfectnumber(6)) {
			System.out.println("Perfectnumber 测试用1通过");
		}
		if(Home03.Perfectnumber(28)) {
			System.out.println("Perfectnumber 测试用2通过");
		}
		
		//factorial 测试用例
		if(Home03.factorial(3)==6) {
			System.out.println("factorial 测试用1通过");
		}
		if(Home03.factorial(5)==120) {
			System.out.println("factorial 测试用2通过");
		}
		//binToDec 测试用例
		if(Home03.binToDec("10").equals("2") ) {
			System.out.println("binToDec 测试用1通过");
		}
		if(Home03.binToDec("10101").equals("21") ) {
			System.out.println("binToDec 测试用2通过");
		}
		
		//求解二元一次方程的测试用例 自己想怎么写，方程肯定有两个不同的解，也就是deta>0,解没有顺序要求，那个放在前面都都行
		if(Home03.getRoot(1,-2,1)[0]==1&&Home03.getRoot(1,-2,1)[1]==1) {
			System.out.println("getRoot测试用1通过");
		}//deta=0,即两个实数解相同
		if((Home03.getRoot(1,1,-6)[0]==2&&Home03.getRoot(1,1,-6)[1]==-3)||(Home03.getRoot(1,1,-6)[0]==-3&&Home03.getRoot(1,1,-6)[1]==2)) {
			System.out.println("getRoot测试用2通过");
		}//deta>0,即两个实数解不同
		if(Home03.getRoot(1,-2,2)==null) {
			System.out.println("getRoot测试用3通过");
		}//deta<0,即无实数解
		
		//getPascalTriangle测试用例自己想想怎么写
			 if (Arrays.equals(Home03.getPascalTriangle(5), new int[]{1, 4, 6, 4, 1})) {
					System.out.println("getPascalTriangle 测试用1通过");
				}
			 if (Arrays.equals(Home03.getPascalTriangle(1), new int[]{1})) {
					System.out.println("getPascalTriangle 测试用2通过");
				}
		
		//zipSpace 测试用例
		
		if(Home03.zipSpace("1 2").equals("12") ) {
			System.out.println("zipSpace 测试用1通过");
		}
	}
	 

}

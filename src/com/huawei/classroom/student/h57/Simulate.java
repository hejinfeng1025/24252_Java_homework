package com.huawei.classroom.student.h57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Simulate {
	public SimResult sim(Param param,int days) {
		int familysize=param.getFamilySize();//一个家庭有几人
		int companysize=param.getCompanySize();//一个公司有几人
		List<Integer>people=new ArrayList<>();
		int size=param.getCityPopulation();//人口
		for(int i=0;i<size;i++)people.add(i);
		Collections.shuffle(people);
		HashMap<Integer, Integer>company=new HashMap<>();//每个人对应的公司编号
		HashSet<Integer>notSick=new HashSet<>();//完全免疫的人
		HashSet<Integer>dead=new HashSet<>();//死人
		for(int i=0;i<size;i++) {
			company.put(people.get(i), i/companysize);
		}
		List<Integer>immu=new ArrayList<>();//打疫苗的人，为1代表打了疫苗
		for(int i=0;i<size;i++)immu.add(0);
		Collections.shuffle(people);
		int immucnt=(int) (size*param.getImmuRate());//打疫苗的人数
		for(int i=0;i<immucnt;i++)immu.set(people.get(i), 1);
		List<Integer>hospital=new ArrayList<>();//住院的人
		List<Integer>wait=new ArrayList<>();//在家的人
		int front=0;
		int latentPeriod=param.getLatentPeriod();//潜伏期
		List<Pair>latent=new ArrayList<>();//感染人的编号，从哪天开始感染的
		for(int i=0;i<param.getInitPatients().size();i++) {
			latent.add(new Pair(param.getInitPatients().get(i), 0));
		}
		Random random=new Random();
		List<Integer>state=new ArrayList<>();//0没事，1潜伏，2生病
		for(int i=0;i<size;i++)state.add(0);
		for(int i=0;i<latent.size();i++) {
			state.set(latent.get(i).getNum(), 1);
		}
		for(int i=0;i<days;i++) {
			List<Integer>com=new ArrayList<>();
			List<Integer>house=new ArrayList<>();
			for(int j=0;j<size/familysize;j++)house.add(0);
			for(int j=0;j<size/companysize;j++)com.add(0);
			for(int j=0;j<latent.size();j++) {
				house.set(latent.get(j).getNum()/familysize, 1);
				com.set(company.get(latent.get(j).getNum()), 1);
			}
			for(int j=front;j<wait.size();j++) {
				house.set(wait.get(j)/familysize, 1);
			}
			for(int j=hospital.size()-1;j>=0;j--) {
				double value=random.nextDouble();
				if(value<param.getHealingRateHospital()) {
					notSick.add(hospital.get(j));
					hospital.remove(j);
					continue;
				}
				value=random.nextDouble();
				if(value<param.getDeathRateHospital()) {
					dead.add(hospital.get(j));
					hospital.remove(j);
				}
			}
			for(int j=wait.size()-1;j>=0;j--) {
				double value=random.nextDouble();
				if(value<param.getHealingRateHome()) {
					notSick.add(wait.get(j));
					wait.remove(j);
					continue;
				}
				value=random.nextDouble();
				if(value<param.getDeathRateHome()) {
					dead.add(wait.get(j));
					wait.remove(j);
				}
			}
			for(int j=latent.size()-1;j>=0;j--) {
				if(i-latent.get(j).getDay()==param.getLatentPeriod()) {
					wait.add(latent.get(j).getNum());
					state.set(latent.get(j).getNum(), 2);
					latent.remove(j);
				}
			}
			for(int j=0;j<size;j++)if(state.get(j)==0&&!notSick.contains(j)&&!dead.contains(j)) {
				double value=random.nextDouble();
				double rate=param.getSpreadRateCompany();
				if(immu.get(j)==1)rate=rate*(1.0-param.getImmuEffect());
				if(value<rate&&com.get(company.get(j))==1) {
					state.set(j, 1);
					latent.add(new Pair(j, i));
					continue;
				}
				value=random.nextDouble();
				rate=param.getSpreadRateFamily();
				if(immu.get(j)==1)rate=rate*(1.0-param.getImmuEffect());
				if(value<rate&&house.get(j/familysize)==1) {
					state.set(j, 1);
					latent.add(new Pair(j, i));
				}
			}
			while(front<wait.size()&&hospital.size()<param.getHospitalSize()) {
				hospital.add(wait.get(front));
				front++;
			}
			for(int j=front-1;j>=0;j--) {
				wait.remove(j);
			}
			front=0;
		}
		SimResult ans=new SimResult();
		ans.setCured(notSick.size());
		ans.setDeaths(dead.size());
		ans.setLatents(latent.size());
		ans.setPatients(hospital.size()+wait.size()-front);
		return ans;
	}
}

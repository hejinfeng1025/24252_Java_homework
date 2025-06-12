package com.huawei.classroom.student.h55;

import java.io.*;
import java.util.*;

public class VoteRecord {
	/**
	 * fileName是一个投票的明细记录，里面逐行存放了 投票的时间（yyyy-MM-dd HH:mm:ss 格式） +\t+投票的微信ID+\t+候选人
	 * 注意这里已经告诉你用啥分割字符串了
	 * 存放按时间递增（但是可能出现同一秒出现若干条记录的情况）
	 * 现在需要完成投票统计的过程，具体要求如下：
	 * 1个微信ID 1分钟内 最多投1票 多余的票数无效
	 * 1个微信ID 10分钟内 最多只能投5票 多余的票无效
	 * 其中微信ID不固定，候选人姓名不固���
	 * 测试的时候要求10万行记录处理时间不超过3秒
	 * @param fileName
	 * @return 返回一个map，其中key是候选人名字，value的票数
	 */
	public Map<String,Integer> calcRecording(String fileName){
       //返回值每一行示例：wang 3358
		List<Record> records = readLines(fileName);
		Map<String,Integer> result = new HashMap<>();
		Map<String, Voter> voterMap = new HashMap<>();
		Map<String, Integer> candidates = new HashMap<>();

		if (records == null || records.isEmpty()) {
			return result; // 如果没有记录，直接返回空的结果
		}

		for(Record r:records){
			Voter voter = voterMap.get(r.getVoterId());
			if (voter == null) {
				voter = new Voter(r.getVoterId());
				voterMap.put(r.getVoterId(), voter);
			}
			voter.addRecord(r);
		}
		//统计所有微信ID的有效投票，合并每个候选人的票数
		for (Voter voter : voterMap.values()) {
			voter.removeInvalidRecords();
			//获取该选民的有效投票，统计每个候选人获得的票数，结果是一个Map
			Map<String, Integer> oneCandidates = voter.getCandidates();
			//将该选民的候选人-票数键值对转为Entry集合，方便遍历
			Set<Map.Entry<String, Integer>> oneCandidatesNameCount = oneCandidates.entrySet();
			//遍历该选民的每个候选人及其票数
			for (Map.Entry<String, Integer> entry : oneCandidatesNameCount) {
				String candidate = entry.getKey();
				int count = entry.getValue();
				if (candidates.containsKey(candidate)) {//如果总票数Map中已存在该候选人，则累加票数
					count += candidates.get(candidate);
				}
				candidates.put(candidate, count);//将累加后的票数放入总票数Map中
			}
		}
		return candidates;
	}

	public List<Record> readLines(String filename) {
		String line = "";
		Reader reader = null;
		List<Record> result = new ArrayList<>();
		//创建一个FileReader对象，读取文件内容
		try {
			reader = new FileReader(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (reader == null) {
			return null;
		}
		//创建一个LineNumberReader对象，用于逐行读取文件内容
		LineNumberReader lineReader = new LineNumberReader(reader);

		try {
			while (true) {
				line = lineReader.readLine();
				if (line == null) {
					break;
				}
				//搞到记录列表里，用数组来把三个参数分开
				String[] recordItems = line.split("\t");
				String date = recordItems[0];
				String voterId = recordItems[1];
				String candidate = recordItems[2];
				Record record = new Record(date, voterId, candidate);
				result.add(record);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}

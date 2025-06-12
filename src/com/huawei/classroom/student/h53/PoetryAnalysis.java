package com.huawei.classroom.student.h53;

import java.io.*;
import java.util.*;


public class PoetryAnalysis {

	private String[] verses = new String[0];
	private Set<String> charSet = new HashSet<>();


	public void analysis(String pathFilename,String chars) {
		String content = readFromTxt(pathFilename);
		// 将输入的汉字字符串按分号分割成数组
		String[] strings = chars.split(";");
		List<Map.Entry<String, Integer>> result = new ArrayList<>();
		charSet = new HashSet<>(Arrays.asList(strings));
		// 按逗号和句号分割诗句
		verses = content.split("[，。]");

		// 获取出现频率最高的10个词
		result = getTopNWords(10);
		// 输出结果
		for(Map.Entry<String, Integer> res : result) {
			System.out.println(res.getKey() + "\t" + res.getValue());
		}
	}

	/**
	 * 获取所有诗句中出现频率最高的n个词（两个相邻汉字组成的词）
	 * 仅统计包含指定汉字集合中至少一个汉字的词
	 * @param n 需要返回的高频词数量
	 * @return 高频词及其出现次数的列表
	 */
	public List<Map.Entry<String, Integer>> getTopNWords(int n){
		int i, j;
		Map<String, Integer> map = new HashMap<>(); // 词频统计map
		List<Map.Entry<String, Integer>> mapList;
		List<Map.Entry<String, Integer>> ans = new ArrayList<>();

		// 遍历每一句诗
		for(i=0;i< this.verses.length;i++){//双层循环，遍历每一句
			String content = this.verses[i];
			for(j=0;j< content.length()-1;j++){// 遍历每一句中的每个词（两个相邻汉字）
				String str = content.substring(j, j+2);
				// 仅统计包含指定汉字集合中至少一个汉字的词
				if(!charSet.contains(str.substring(0, 1)) && !charSet.contains(str.substring(1,2))) {
					continue;
				}
				int count;
				count = map.getOrDefault(str,0);
				map.put(str, count + 1);
			}
		}

		// 将map转为列表并按出现次数降序排序
		mapList = new ArrayList<>(map.entrySet());
		mapList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		// 只取前n个高频词
		int limit = Math.min(n, mapList.size());
		for(int k = 0; k < limit; k++){
			ans.add(mapList.get(k));
		}
		return ans;
	}

	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// 关闭流时发生异常
				e.printStackTrace();
			}
		}
	}

	private String readFromTxt(String filename){
		Reader reader = null;
		StringBuffer buf = new StringBuffer();
		try {
			char[] chars = new char[1024];
			// 使用UTF-8编码读取文件
			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
		} catch (Exception e) {
			e.printStackTrace();}
		finally {
			close(reader);
		}
		return buf.toString();
	}

}

package com.huawei.classroom.student.h53;

import java.io.*;
import java.util.*;


public class PoetryAnalysis {

	/**
	 * 
	 * @param pathFilename 包含诗歌内容的源文件
	 * @param chars 需要统计的字 以半角分号分割 
	 * 统计  
	 * 
	 */
	//verses是诗句数组,用逗号和句号分割
	private String[] verses = new String[0];
	//charSet是需要统计的汉字集合（用半角分号分割的字符串转换而来）
	private Set<String> charSet = new HashSet<>();

	public void analysis(String pathFilename,String chars) {
		//读入文件
		String content = readFromTxt(pathFilename);
		String[] strings = chars.split(";");
		List<Map.Entry<String, Integer>> result = new ArrayList<>();

		charSet = new HashSet<>(Arrays.asList(strings));
		verses = content.split("[，。]");

		result = getTopNWords(10);
		for(Map.Entry<String, Integer> res : result) {
			System.out.println(res.getKey() + "\t" + res.getValue());
		}
	}

	//获取verses所有加起来中出现频率最高的n个词
	public List<Map.Entry<String, Integer>> getTopNWords(int n){
		int i, j;
		Map<String, Integer> map = new HashMap<>();
		List<Map.Entry<String, Integer>> mapList;
		List<Map.Entry<String, Integer>> ans = new ArrayList<>();

		for(i=0;i< this.verses.length;i++){//双层循环，遍历每一句
			String content = this.verses[i];
			for(j=0;j< content.length()-1;j++){//遍历每一句中的每个词（两个相邻汉字）
				String str = content.substring(j, j+2);
				if(!charSet.contains(str.substring(0, 1)) && !charSet.contains(str.substring(1,2))) {
					continue;
				}
				int count;
				count = map.getOrDefault(str,0);
				map.put(str, count + 1);
			}
		}

		mapList = new ArrayList<>(map.entrySet());
		mapList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		int limit = Math.min(n, mapList.size());
		for(int k = 0; k < limit; k++){
			ans.add(mapList.get(k));
		}
		return ans;
	}
	//关闭输入输出流
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//从文件中读取文本内容
	private String readFromTxt(String filename){
		Reader reader = null;
		StringBuffer buf = new StringBuffer();
		try {
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

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
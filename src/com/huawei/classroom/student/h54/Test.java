package com.huawei.classroom.student.h54;

/**
 * 文件的批量替换， 难度系数2星
 * @author cjy
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileTool home = new FileTool();
		String homeDir = "xxxx/test_dir1/";
		// 将一根目录下所有文本文件内容做替换，具体要求见 replaceTxtFileContent 方法
		// 此题目要求精确匹配答案
		home.replaceTxtFileContent(homeDir, "南开大学", "天津大学");
	}
}

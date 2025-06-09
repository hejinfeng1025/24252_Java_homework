/**
 * 
 */
package com.huawei.classroom.student.h54;

import java.io.*;

/**
 * @author Administrator
 *
 */
public class FileTool {
	private String orgStr = "";
	private String targetStr = "";
	/**
	 * 将homeDir 目录下（包括子目录）所有的文本文件（扩展名为.txt，扩展名不是.txt的文件不要动，扩展名区分大小写) 文件中，orgStr替换为 targetStr
	 * 所有文本文件均为UTF-8编码
	 * 例如将某个目录中所有文本文件中的 南开大学 替换为 天津大学
	 * @param homeDir
	 * @param orgStr
	 * @param targetStr
	 */

	public void replaceTxtFileContent(String homeDir,String orgStr,String targetStr) throws Exception {
		this.orgStr = orgStr;
		this.targetStr = targetStr;
		//对于目录和文件，都用File来封装
		File directory = new File(homeDir);
		//递归检查文件夹
		replaceFilesRecursively(directory);

	}
	/*
	*备用，判断是否为文本文件
	private boolean isTxtFile(String filename) {
		String[] filenames = filename.split("\\.");
		String ext = filenames[filenames.length - 1];
		return EXTNAME.equalsIgnoreCase(ext);
	}
	 */
		public void replaceFilesRecursively(File directory) throws Exception {
		// 检查当前路径是否是目录
		if (!directory.isDirectory()) {
			return;
		}
		// 获取目录中的所有文件和子目录
		File[] files = directory.listFiles();
		if (files != null) {
			for (File file : files) {
				// 检查是不是txt文件
				if(file.getName().endsWith(".txt")) {
					// 读取原文件内容
					String content = readFromTxt(file.getAbsolutePath());
					// 替换内容
					String newContent = content.replace(orgStr, targetStr);
					//写回文件
					try {
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(newContent);
						bw.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 如果是目录，则递归调用
				if (file.isDirectory()) {
					replaceFilesRecursively(file);
				}
			}
		}

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
		private String readFromTxt(String filename) throws Exception {
			Reader reader = null;
			try {
				StringBuffer buf = new StringBuffer();
				char[] chars = new char[1024];
				// InputStream in=new FileInputStream(filename);

				reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
				int readed = reader.read(chars);
				while (readed != -1) {
					buf.append(chars, 0, readed);
					readed = reader.read(chars);
				}
				return buf.toString();
			} finally {
				close(reader);
			}
		}

}
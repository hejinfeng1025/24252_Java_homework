package com.huawei.classroom.student.h58;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class FTPFile {
	/**
	 * 这个类下面所有的代码都没有实现，请实现这个类里面的方法，如果有必要可以增加适当的方法和类
	 * @param server
	 * @param pathFileName
	 * @throws Exception
	 */

	private MyFTPServer server;
	private String name;
	private Socket socket;
	public FTPFile(MyFTPServer server, String pathFileName) throws Exception {
		this.server=server;
		this.name=pathFileName;
		this.socket=server.query();
	}

	/**
	 * 按文件名升序的方式列出所有的目录和文件，和java中File.listFiles功能类似
	 * @return
	 * @throws Exception
	 */
	public FTPFile[] listFiles() throws Exception {
		try {
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			out.println("list,"+this.name);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response=in.readLine();
			String[] temp=response.split(",");
			List<String>dire=new ArrayList<String>();
			List<String>fi=new ArrayList<>();
			for(int i=0;i<temp.length;i++) {
				if(temp[i].endsWith("/"))dire.add(temp[i]);
				else fi.add(temp[i]);
			}
			Collections.sort(dire);
			Collections.sort(fi);
			FTPFile[] ans=new FTPFile[temp.length];
			for(int i=0;i<dire.size();i++) {
				ans[i]=new FTPFile(server, dire.get(i));
			}
			for(int i=0;i<fi.size();i++) {
				ans[i+dire.size()]=new FTPFile(server, fi.get(i));
			}
			return ans;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 是否是目录
	 * @return
	 * @throws Exception
	 */
	public boolean isDirectory() throws Exception {
		try {
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			out.println("isd,"+this.name);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response=in.readLine();
			if(response.equals("true"))return true;
			else return false;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 是否是文件
	 * @return
	 * @throws Exception
	 */
	public boolean isFile() throws Exception {
		try {
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			out.println("isf,"+this.name);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response=in.readLine();
			if(response.equals("true"))return true;
			else return false;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 返回相对于ftp_home的路径+文件名
	 * @return
	 * @throws Exception
	 */
	public String getPathFileName() throws Exception {
		return  this.name;
	}
	/**
	 * 如果是文件，返回文件大小
	 * @return
	 * @throws Exception
	 */
	public long length() throws Exception {
		if(this.isFile()) {
			try {
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println("length,"+this.name);
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String response=in.readLine();
				long ans=Long.valueOf(response);
				return ans;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**
	 * 如果是文件，把文件全部内容读入到byte[]中，不需要考虑内存不够情况
	 * @return
	 * @throws Exception
	 */
	public byte[] readToBytes() throws Exception {
		if(this.isFile()) {
			try {
				PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
				out.println("read,"+this.name);
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String response=in.readLine();
				byte[] ans=response.getBytes();
				return ans;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}

}

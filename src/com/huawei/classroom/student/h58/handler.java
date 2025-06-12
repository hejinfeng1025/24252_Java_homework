package com.huawei.classroom.student.h58;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class handler extends Thread{
	private Socket clientsock;
	private String name;
	public handler(Socket clientsock,String name) {
		this.clientsock=clientsock;
		this.name=name;
	}
	@Override
	public void run() {
		try {
			InputStream inputStream=clientsock.getInputStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
			PrintWriter out=new PrintWriter(clientsock.getOutputStream(),true);
			String message;
			while((message=reader.readLine())!=null) {
				String[] temp=message.split(",");
				if(temp[0].equals("list")) {
					File file=new File(this.name+temp[1]);
					String[] ans=file.list();
					StringBuffer re=new StringBuffer();
					for(int i=0;i<ans.length;i++) {
						File t=new File(this.name+temp[1]+ans[i]);
						ans[i].replace(this.name, "");
						re.append(temp[1]);
						re.append(ans[i]);
						if(t.isDirectory())re.append("/");
						if(i!=ans.length-1)re.append(",");
					}
					out.println(re);
				}
				else if(temp[0].equals("isd")) {
					File file=new File(this.name+temp[1]);
					if(file.isDirectory())out.println("true");
					else out.println("false");
				}
				else if(temp[0].equals("isf")) {
					File file=new File(this.name+temp[1]);
					if(file.isFile())out.println("true");
					else out.println("false");
				}
				else if(temp[0].equals("length")) {
					File file=new File(this.name+temp[1]);
					long length=file.length();
					out.println(length);
				}
				else {
					StringBuffer ans=new StringBuffer();
					BufferedReader br=new BufferedReader(new FileReader(this.name+temp[1]));
					String line;
					while((line=br.readLine())!=null) {
						ans.append(line);
					}
					out.println(ans);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

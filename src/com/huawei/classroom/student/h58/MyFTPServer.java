package com.huawei.classroom.student.h58;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 
/**
 * 
 * 
 */
public class MyFTPServer extends Thread{

	/**
	 * 这个类下面所有的代码都没有实现，请实现这个类里面的方法，如果有必要可以增加适当的方法和类
	 * @param ip
	 * @param port
	 * @param remoteHome
	 * @throws Exception
	 */
	private String file;
	private String ip;
	private int port;
	private ExecutorService threadpool;
    public MyFTPServer(String ip,int port,String remoteHome ) throws Exception{    	
    	this.ip=ip;
    	this.port=port;
    	this.file=remoteHome;
    	if(this.file.endsWith("/"))this.file=this.file.substring(0,this.file.length()-1);
    	this.threadpool=Executors.newCachedThreadPool();
    }


    public boolean login(String username,String password) {
    	return true;
    }

    public void run() {
    	try {
    		ServerSocket serverSocket=new ServerSocket(this.port);
    		while(true) {
    			Socket socket=serverSocket.accept();
        		threadpool.execute(new handler(socket,this.file));
    		}
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
    public Socket query() throws Exception{
    	return new Socket(this.ip,this.port);
    }

}

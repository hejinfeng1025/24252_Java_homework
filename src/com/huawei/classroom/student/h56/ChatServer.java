package com.huawei.classroom.student.h56;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer extends Thread{
	private final ServerSocket server;
	private final Map<String, String> passwd;
	public static List<Socket> clients = new ArrayList<>();

	/**
	 * 初始化 ， 根据情况适当抛出异常
	 * @param port
	 * @param passwordFilename 所有用户的用户名 口令
	 */
	//多线程：服务器要能同时处理多个客户端，所以每个连接用一个线程。
	//同步：多个线程操作共享资源（如消息队列、客户端列表）时要注意同步。
	public ChatServer (int port, String passwordFilename) throws IOException {
		server = new ServerSocket(port);
		passwd = readLines(passwordFilename);
	}
	/**
	 *  根据情况适当抛出异常
	 * 开始监听
	 */
	public void startListen( ) {
		this.start();
	}
	//当你调用start()方法时，线程会自动执行run()里的代码。如果不重写，线程什么都不会做。
	@Override
	public void run() {
		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			clients.add(socket);
			new ServerThread(socket, passwd).start();
		}
	}

	//按行读入文件内容
	public Map<String, String> readLines(String filename) throws IOException {
		String line;
		Reader reader;
		Map<String, String> result = new HashMap<>();
		reader = new FileReader(filename);
		LineNumberReader lineReader = new LineNumberReader(reader);

		while (true) {
			line = lineReader.readLine();
			if (line == null) {
				break;
			}
			if (line.trim().length() == 0 || line.startsWith("#")) {
				continue;
			}
			String[] lineContent = line.split("\t");
			result.put(lineContent[0], lineContent[1]);
		}
		return result;
	}

}

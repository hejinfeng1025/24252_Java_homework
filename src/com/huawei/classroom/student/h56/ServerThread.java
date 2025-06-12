package com.huawei.classroom.student.h56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

/**
 * @author hejinfeng
 * @create 2025-06-12 11:52
 */
public class ServerThread extends Thread {
    private final Socket socket;
    private final Map<String, String> passwd;

    public ServerThread(Socket socket, Map<String, String> passwd) {
        super();
        this.socket = socket;
        this.passwd = passwd;
    }

    //服务器端线程处理客户端连接的核心逻辑
    @Override
    public void run() {
        try {
            //为当前客户端的Socket创建输入流和输出流，方便后续收发消息。
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //读取客户端发来的第一行数据（用户名和密码），保存到passwdStr。
            String line = in.readLine();
            String passwdStr = line;
//            System.out.println("server received username and password: " + passwdStr);
            //调用pass()方法校验用户名和密码，将校验结果（"1"表示成功，"0"表示失败）写回客户端。
            String isLoggedIn = pass(passwdStr);
            out.write(isLoggedIn + "\r\n");
            out.flush();
            //如果登录失败，直接结束线程。
            if ("0".equals(isLoggedIn)) {
                return;
            }

            //进入循环，不断读取当前客户端的发言。
            //每收到一条消息，就遍历所有已连接的客户端，将消息广播给每个客户端。
            while (true) {
                line = in.readLine();
                // \r\n is necessary
                for (Socket client : ChatServer.clients) {
                    PrintWriter clientOut = new PrintWriter(client.getOutputStream());
                    clientOut.write(line + "\r\n");
                    clientOut.flush();
                }
                if (1 == 0) {
                    break;
                }
            }
            //关闭输入输出流和Socket连接，释放资源。
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param passwdStr username + \t + password
     * @return "1" or "0"
     */
    private String pass(String passwdStr) {
        String[] userPasswd = passwdStr.split("\t");
        if (userPasswd.length != 2) {
            return "0";
        }
        String username = userPasswd[0];
        String password = userPasswd[1];
        //获取所有用户名和密码的键值对集合。
        Set<Map.Entry<String, String>> passwdEntry = passwd.entrySet();
        //遍历所有用户名和密码。
        for (Map.Entry<String, String> entry : passwdEntry) {
            if (username.equals(entry.getKey())) {//如果找到用户名匹配的项：
                if (password.equals(entry.getValue())) {//如果密码也匹配，返回"1"（登录成功）；否则返回"0"（密码错误）
                    return "1";
                } else {
                    return "0";
                }
            }
        }
        return "0";
    }
}

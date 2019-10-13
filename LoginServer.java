package com.java.zwen.test.day02.p2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器
public class LoginServer {
    public static void main(String[] args) {
        //创建一个Socket
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            //使用accept()监听并接收到此ServerSocket的连接
            Socket socket = serverSocket.accept();
            //获得输入流，或得用户请求
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            User user = (User)ois.readObject();
            System.out.println("客户端说"+user.getUserName()+"-"+user.getPwd());

            //给客户端一个响应
            String reply = "欢迎登陆!!!";
            //通过输出流将响应发送给客户端
            OutputStream os = socket.getOutputStream();
            os.write(reply.getBytes());
            //释放资源
            os.close();
            ois.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

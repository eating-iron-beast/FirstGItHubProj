package com.java.zwen.test.day02.p2;

import java.io.*;
import java.net.Socket;

//客户端
public class LoginClient {
    public static void main(String[] args) {
        try {
            //发送请求到服务器
            //创建一个客户端的Sockt
            Socket socket = new Socket("localhost",5000);
            User user = new User("Tom","123456");
            OutputStream os = socket.getOutputStream();
            //将输出流包装成对象的输出流
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(user);
           /* String info = "用户名：Tom；密码：123456";
            OutputStream os = socket.getOutputStream();
            byte[] infos = info.getBytes();
            os.write(infos);*/

            //暂时关闭输出流
            socket.shutdownOutput();
            //接收服务器给我的响应
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String reply;
            while((reply = br.readLine())!= null){
                System.out.println("服务器说："+reply);
            }

            //释放资源
            br.close();
            is.close();
            oos.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

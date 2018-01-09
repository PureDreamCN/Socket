/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:Socket
 * Module Name:TODO:Module
 */


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 郭飞 created on 2018/1/4
 */
public class ServerSocket1 {

    public static void main(String[] args){
        Socket socket =null;
        try {
            //创建服务端socket
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务端启动");
            //客户端数量
            int count = 0;
            //循环监听请求
            while(true){
                //监听
                socket = serverSocket.accept();
                //获取到请求则新建 线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端数量"+count);
            }
           /* //获取输入流
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("这里是服务器，客户端说："+info);
            }
            //关闭输入流
            socket.shutdownInput();
            //向客户端回应
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("你好");
            pw.flush();
            pw.close();
            os.close();


            //关闭资源
            br.close();
            isr.close();
            in.close();
            socket.close();
            serverSocket.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

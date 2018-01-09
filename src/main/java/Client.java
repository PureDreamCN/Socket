/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:Socket
 * Module Name:TODO:Module
 */

import java.io.*;
import java.net.Socket;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 郭飞 created on 2018/1/4
 */
public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream os = socket.getOutputStream();
            PrintWriter ps = new PrintWriter(os);
            //向服务端发送消息
            ps.write("我是客户端");
            ps.flush();
            //关闭输出流
            socket.shutdownOutput();

            //获取服务端消息
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("这里是客户端，服务端对我说:"+info);
            }
            br.close();
            isr.close();

            //关闭资源
            ps.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

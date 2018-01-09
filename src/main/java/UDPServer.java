/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:Socket
 * Module Name:TODO:Module
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 郭飞 created on 2018/1/4
 */
public class UDPServer {

    public static void main(String[] args){
        try {
            //创建socket
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            //创建用于接收的数据报
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            //接收客户端的信息
            datagramSocket.receive(packet);
            String info = new String(data,0, packet.getLength());
            System.out.println("我是服务器，客户端说："+info);

            //服务器详客户端响应发
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

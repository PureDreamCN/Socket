/**
 * Copyright 2017 弘远技术研发中心. All rights reserved
 * Project Name:Socket
 * Module Name:TODO:Module
 */

import java.io.IOException;
import java.net.*;

/**
 * what:    (这里用一句话描述这个类的作用). <br/>
 * when:    (这里描述这个类的适用时机 – 可选).<br/>
 * how:     (这里描述这个类的使用方法 – 可选).<br/>
 * warning: (这里描述这个类的注意事项 – 可选).<br/>
 *
 * @author 郭飞 created on 2018/1/4
 */
public class UDPClient {
    public static void main(String[] args){

        try {
            //定义服务器的地址，端口号，数据
            InetAddress address = InetAddress.getByName("localhost");
            int port = 8888;
            byte[] data= "这是客户端传过来的数据".getBytes();
            //创建数据报
            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
            //创建socket
            DatagramSocket datagramSocket = new DatagramSocket();
            //发送消息
            datagramSocket.send(packet);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

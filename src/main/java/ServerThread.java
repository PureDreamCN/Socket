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
public class ServerThread  extends  Thread{
    private Socket socket = null;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //获取输入流
        InputStream in = null;
        PrintWriter pw =null;
        OutputStream os = null;
        BufferedReader br = null;
        InputStreamReader isr = null;
        try {
            in = socket.getInputStream();
            isr = new InputStreamReader(in);
            br = new BufferedReader(isr);
            String info = null;
            while((info=br.readLine())!=null){
                System.out.println("这里是服务器，客户端说："+info);
            }
            //关闭输入流
            socket.shutdownInput();
            //向客户端回应
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("你好");
            pw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pw!=null){
                    pw.close();
                }
                if(os!=null){
                    os.close();
                }
                if(br!=null){
                    br.close();
                }
                if(isr!=null){
                    isr.close();
                }
                if(in!=null){
                    in.close();
                }
                if(socket!=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

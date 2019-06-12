package cn.ccuIot.tcpCloud.socketServer.sensor;

import cn.ccuIot.tcpCloud.entity.Message;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Send2Sensor{

    public static Socket socket;

    public static void send(String message) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 获得输出流
            PrintWriter pw = new PrintWriter(bw);
            pw.print(message);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

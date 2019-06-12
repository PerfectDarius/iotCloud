package cn.ccuIot.tcpCloud.socketServer.mobile;

import cn.ccuIot.tcpCloud.entity.Message;
import cn.ccuIot.tcpCloud.service.MobileInformationService;
import cn.ccuIot.tcpCloud.service.impl.MobileInformationServiceImpl;
import cn.ccuIot.tcpCloud.socketServer.SensorConnection;
import cn.ccuIot.tcpCloud.socketServer.sensor.Send2Sensor;

import javax.annotation.Resource;
import java.io.*;
import java.net.Socket;

public class ReceiveFromMobile implements Runnable {

    private Socket socket;

    public ReceiveFromMobile(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 接受客服端发送的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 获得输出流
            PrintWriter pw = new PrintWriter(bw);
            while (true) {
                String message = br.readLine();
                if ("bye".equalsIgnoreCase(message)||message==null) {
                    socket.close();
                    SensorConnection.serverSocket.close();
                    break;
                }
                System.out.println("手机:" +message);// 输出屏幕上得到的数据
                Message.MOBILE_RECEIVE_MSG = message;
                if (Send2Sensor.socket != null && Send2Sensor.socket.isConnected()) {
                    Send2Sensor.send(Message.MOBILE_RECEIVE_MSG);
                }
            }

            /*InputStream inputStream = socket.getInputStream();
            int len = 0;
            byte[] car = new byte[1024];
            while((len = inputStream.read(car))!= -1) {    //3、操作：以每次car大小读取
                String ss = new String(car,0,len);    // 将byte类型的数组转化成字符串，方便下面输出
                System.out.println(ss);
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

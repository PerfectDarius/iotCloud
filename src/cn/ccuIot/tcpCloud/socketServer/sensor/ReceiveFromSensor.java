package cn.ccuIot.tcpCloud.socketServer.sensor;

import cn.ccuIot.tcpCloud.entity.InformationVo;
import cn.ccuIot.tcpCloud.entity.Message;
import cn.ccuIot.tcpCloud.service.SensorInformationService;
import cn.ccuIot.tcpCloud.service.impl.SensorInformationServiceImpl;
import cn.ccuIot.tcpCloud.socketServer.SensorConnection;
import cn.ccuIot.tcpCloud.socketServer.mobile.Send2Mobile;
import com.google.gson.Gson;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ReceiveFromSensor implements Runnable{

    @Resource
    SensorInformationService sensorInformationService;

    private Socket socket;

    public ReceiveFromSensor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            int i=0;
            // 接受客服端发送的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            InputStream inputStream = socket.getInputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));// 获得输出流
            PrintWriter pw = new PrintWriter(bw);
            while (true) {

                String message = br.readLine();
                if ("bye".equalsIgnoreCase(message)||message==null) {
                    socket.close();
                    SensorConnection.serverSocket.close();
                    break;
                }
                System.out.println("SENSOR_MESSAGE:" +message+" __ "+new Date());// 输出屏幕上得到的数据

                Gson gson = new Gson();
                InformationVo informationVo = gson.fromJson(message, InformationVo.class);

                //T1,T2,L,C,S 可用集合 + 索引替代
                if ("T1".equalsIgnoreCase(informationVo.getName())) {
                    Message.currentInformationVoList.set(0, informationVo);
                } else if ("T2".equalsIgnoreCase(informationVo.getName())) {
                    Message.currentInformationVoList.set(1, informationVo);
                }else if ("L".equalsIgnoreCase(informationVo.getName())) {
                    Message.currentInformationVoList.set(2, informationVo);
                }else if ("C".equalsIgnoreCase(informationVo.getName())) {
                    Message.currentInformationVoList.set(3, informationVo);
                }else if ("S".equalsIgnoreCase(informationVo.getName())) {
                    Message.currentInformationVoList.set(4, informationVo);
                }

                if (Send2Mobile.socket != null && Send2Mobile.socket.isConnected()) {
                    Send2Mobile.send(message);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

package cn.ccuIot.tcpCloud.controller;

import cn.ccuIot.tcpCloud.entity.Message;
import cn.ccuIot.tcpCloud.socketServer.MobileConnection;
import cn.ccuIot.tcpCloud.socketServer.SensorConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SocketController {

    static Integer sensorPort=9601;
    static Integer mobilePort=9602;

    @RequestMapping("/getMessage")  //获取消息
    public void getMessage( HttpServletResponse response) throws IOException {
        String msg = Message.SENSOR_RECEIVE_MSG;
        response.getWriter().write(msg);
    }

    @RequestMapping("/createSensorConnection.action")   //创建传感器连接
    public String createSensorConnection(HttpServletRequest request) throws IOException {
        String sensorConnectionIp = new SensorConnection(sensorPort).createConnection();
        request.getSession().setAttribute("sensorConnectionIp",sensorConnectionIp);
        return "redirect:index.jsp";
    }

    @RequestMapping("/closeSensorConnection.action")    //关闭传感器连接
    public String closeSensorConnection(HttpServletRequest request) throws IOException {
        SensorConnection.serverSocket.close();
        SensorConnection.socket.close();
        request.getSession().setAttribute("sensorConnectionIp",null);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/createMobileConnection.action")   //创建手机连接
    public String createMobileConnection(HttpServletRequest request) throws IOException {
        String mobileConnectionIp = new MobileConnection(mobilePort).createConnection();
        request.getSession().setAttribute("mobileConnectionIp",mobileConnectionIp);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/closeMobileConnection.action")    //关闭手机连接
    public String closeMobileConnection(HttpServletRequest request) throws IOException {
        MobileConnection.serverSocket.close();
        MobileConnection.socket.close();
        request.getSession().setAttribute("mobileConnectionIp",null);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/createPort.action")
    public String createPort(Integer sensorPort, Integer mobilePort,HttpServletRequest request) {
        SocketController.sensorPort = sensorPort;
        SocketController.mobilePort = mobilePort;
        request.getSession().setAttribute("sensorPort",sensorPort);
        request.getSession().setAttribute("mobilePort",mobilePort);
        return "redirect:/index.jsp";
    }
}

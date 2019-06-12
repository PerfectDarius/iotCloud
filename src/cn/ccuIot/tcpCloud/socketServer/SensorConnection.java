package cn.ccuIot.tcpCloud.socketServer;

import cn.ccuIot.tcpCloud.socketServer.sensor.ReceiveFromSensor;
import cn.ccuIot.tcpCloud.socketServer.sensor.Send2Sensor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SensorConnection{

    public static ServerSocket serverSocket;
    public static Socket socket;
    private int port;

    public SensorConnection(int port) {
        this.port = port;
    }

    public String createConnection() throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        new Thread(new ReceiveFromSensor(socket)).start();
        Send2Sensor.socket = socket;
        return socket.getLocalAddress().toString();
    }


}


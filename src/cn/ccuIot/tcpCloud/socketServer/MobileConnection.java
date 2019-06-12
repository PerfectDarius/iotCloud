package cn.ccuIot.tcpCloud.socketServer;

import cn.ccuIot.tcpCloud.entity.Message;
import cn.ccuIot.tcpCloud.socketServer.mobile.ReceiveFromMobile;
import cn.ccuIot.tcpCloud.socketServer.mobile.Send2Mobile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MobileConnection{
    public static ServerSocket serverSocket;
    public static Socket socket;
    private int port;

    public MobileConnection(int port) {
        this.port = port;
    }

    public String createConnection() throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        new Thread(new ReceiveFromMobile(socket)).start();
        Send2Mobile.socket = socket;
        return socket.getLocalAddress().toString();
    }
}

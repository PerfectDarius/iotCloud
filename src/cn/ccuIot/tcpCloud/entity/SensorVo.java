package cn.ccuIot.tcpCloud.entity;

import cn.ccuIot.tcpCloud.service.impl.SensorInformationServiceImpl;
import cn.ccuIot.tcpCloud.service.impl.SensorServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensorVo {
    private String name;
    private String message;

    public SensorVo(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SensorVo{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static void main(String[] args){

        InformationVo informationVo = new InformationVo();
        informationVo.setName("T1");
        informationVo.setMessage("37.1");
        Gson gson = new Gson();
        String s = gson.toJson(informationVo);
        System.out.println(s);
        String[] arr = {"{\"name\":\"T2\",\"message\":\"99.6\"}", "{\"name\":\"L\",\"message\":\"77.7\"}", "{\"name\":\"T3\",\"message\":\"33.7\"}"};
    }
}

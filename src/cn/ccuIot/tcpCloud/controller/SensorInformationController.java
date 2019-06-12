package cn.ccuIot.tcpCloud.controller;

import cn.ccuIot.tcpCloud.entity.*;
import cn.ccuIot.tcpCloud.service.SensorInformationService;
import cn.ccuIot.tcpCloud.service.SensorService;
import cn.ccuIot.tcpCloud.service.impl.SensorServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class SensorInformationController {
    @Resource
    private SensorInformationService sensorInformationService;

    @Resource
    private SensorService sensorService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @RequestMapping("/queryCurrentSensorInformation.action")    //查询最新传感器消息
    public void queryCurrentSensorInformation(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建一个list用于存储当前的传感器信息
        List<SensorInformation> sensorInformationList = new ArrayList<>();
        //遍历接收传感器信息的列表
        for (InformationVo informationVo : Message.currentInformationVoList) {
            SensorInformation sensorInformation = new SensorInformation();
            //根据informationVo中的name获取Sensor
            Sensor sensor = sensorService.querySensorByName(informationVo.getName());
            sensorInformation.setSensor(sensor);
            sensorInformation.setTime(simpleDateFormat.format(new Date()));
            sensorInformation.setMessage(informationVo.getMessage());
            sensorInformation.setSensor_id(sensor.getSensor_id());
            sensorInformationList.add(sensorInformation);
            for (SensorInformation information : Message.currentSensorInformationList) {
                if (information.getSensor_id() == sensorInformation.getSensor_id() && !information.getMessage().equals(sensorInformation.getMessage())) {
                    sensorInformationService.addSensorInformation(sensorInformation);
                }
            }
        }
        Gson gson = new Gson();
        Message.currentSensorInformationList = sensorInformationList;
        String s = gson.toJson(sensorInformationList);
        response.getWriter().write(s);
    }

    @RequestMapping("/querySensorInformationByLikeMessage.action")  //根须消息关键字查询传感器消息
    public String querySensorInformationByLikeMessage(String keyWord,HttpServletRequest request) {
        List<SensorInformation> sensorInformationList =
                this.sensorInformationService.querySensorInformationByLikeMessage(keyWord);
        Collections.reverse(sensorInformationList);
        request.setAttribute("sensorInformationList", sensorInformationList);
        return "forward:";   //转发至查询传感器消息界面
    }

    @RequestMapping("/querySensorInformationByLikeName.action")     //根据名称关键字查询传感器消息
    public String querySensorInformationByLikeName(String informationName,Model model) {
        List<SensorInformation> sensorInformationList =
                this.sensorInformationService.querySensorInformationByLikeName(informationName);
        Collections.reverse(sensorInformationList);
        model.addAttribute("sensorInformationList", sensorInformationList);
        return "forward:/sensorRecordQuery.jsp";   //转发至查询传感器消息界面
    }

    @RequestMapping("/queryAllSensorInformation.action")
    public String queryAllSensorInformation(Model model) {
        List<SensorInformation> sensorInformationList = this.sensorInformationService.queryAllSensorInformation();
        Collections.reverse(sensorInformationList);
        model.addAttribute("sensorInformationList", sensorInformationList);
        return "forward:/sensorRecordQuery.jsp";
    }
}

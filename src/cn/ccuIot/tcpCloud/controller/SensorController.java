package cn.ccuIot.tcpCloud.controller;

import cn.ccuIot.tcpCloud.entity.Sensor;
import cn.ccuIot.tcpCloud.entity.SensorInformation;
import cn.ccuIot.tcpCloud.entity.SensorVo;
import cn.ccuIot.tcpCloud.service.SensorService;
import cn.ccuIot.tcpCloud.service.impl.SensorServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SensorController {
    @Resource
    private SensorService sensorService;


    @RequestMapping("/addSensor.action")   //添加传感器
    public String addSensor(Sensor sensor) {
        this.sensorService.addSensor(sensor);
        return "redirect:/queryAllSensor.action"; //重定向至传感器列面页面
    }

    @RequestMapping("/deleteSensorById.action")       //根据id删除传感器
    public String deleteSensorById(Integer id) {
        this.sensorService.deleteSensorById(id);
        return "redirect:/queryAllSensor.action"; //重定向至传感器列面页面
    }

    @RequestMapping("/updateSensor.action")       //更改传感器
    public String updateSensor(Sensor sensor) {
        this.sensorService.updateSensor(sensor);
        return "redirect:/queryAllSensor.action"; //重定向至传感器列面页面
    }

    @RequestMapping("/querySensorById.action")     //根据id查询传感器
    public String querySensorById(Integer id,Model model) {
        Sensor sensor = this.sensorService.querySensorById(id);
        model.addAttribute("sensor", sensor);
        return "forward:/editSensor.jsp";  //转发至传感器页面
    }

    @RequestMapping("/queryAllSensor.action")       //查询所有传感器
    public String queryAllSensor(Model model) {
        List<Sensor> sensorList = this.sensorService.queryAllSensor();
        model.addAttribute("sensorList",sensorList);
        return "forward:/sensorManagement.jsp";  //转发至传感器页面
    }

    @RequestMapping("/test.action")
    public void test() {
        String message = "[{\"name\":\"T1\",\"message\":\"33.7\"},{\"name\":\"T2\",\"message\":\"99.6\"},{\"name\":\"S1\",\"message\":\"77.7\"}]";
        SensorInformation sensorInformation = new SensorInformation();
        Gson gson = new Gson();
        List<SensorVo> list = gson.fromJson(message, new TypeToken<List<SensorVo>>(){}.getType());
        Sensor sensor = sensorService.querySensorByName("T1");
        System.out.println(sensor);
    }
}

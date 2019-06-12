package cn.ccuIot.tcpCloud.controller;

import cn.ccuIot.tcpCloud.entity.SensorInformation;
import cn.ccuIot.tcpCloud.service.SensorInformationService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class MobileController {

    @Resource
    SensorInformationService sensorInformationService;


    /**
     * 手机获取传感器消息记录接口
     * */
    @RequestMapping("/mobileQuerySensorInformation.action")
    public void mobileQuerySensorInformation(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<SensorInformation> sensorInformations = this.sensorInformationService.queryAllSensorInformation();
        Gson gson = new Gson();
        String toJson = gson.toJson(sensorInformations);
        response.getWriter().write(toJson);
    }

}

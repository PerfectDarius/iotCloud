package cn.ccuIot.tcpCloud.service.impl;

import cn.ccuIot.tcpCloud.dao.SensorInformationMapper;
import cn.ccuIot.tcpCloud.entity.Sensor;
import cn.ccuIot.tcpCloud.entity.SensorInformation;
import cn.ccuIot.tcpCloud.entity.SensorVo;
import cn.ccuIot.tcpCloud.service.SensorInformationService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SensorInformationServiceImpl implements SensorInformationService {


    @Resource
    SensorInformationMapper sensorInformationMapper;

    @Override
    public List<SensorInformation> queryAllSensorInformation() {
        return this.sensorInformationMapper.queryAllSensorInformation();
    }

    @Override
    public List<SensorInformation> querySensorInformationByLikeMessage(String msg) {
        return this.sensorInformationMapper.querySensorInformationByLikeMessage(msg);
    }

    @Override
    public List<SensorInformation> querySensorInformationByLikeName(String name) {
        return this.sensorInformationMapper.querySensorInformationByLikeName(name);
    }

    @Override
    public void addSensorInformation(SensorInformation sensorInformation) {
        this.sensorInformationMapper.addSensorInformation(sensorInformation);
    }


}

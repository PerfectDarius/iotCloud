package cn.ccuIot.tcpCloud.service.impl;

import cn.ccuIot.tcpCloud.dao.SensorInformationMapper;
import cn.ccuIot.tcpCloud.dao.SensorMapper;
import cn.ccuIot.tcpCloud.entity.Sensor;
import cn.ccuIot.tcpCloud.service.SensorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    @Resource
    private SensorMapper sensorMapper;
    @Resource
    private SensorInformationMapper sensorInformationMapper;

    @Override
    public void addSensor(Sensor sensor) {
        this.sensorMapper.addSensor(sensor);
    }

    @Override
    public void deleteSensorById(Integer id) {
        this.sensorInformationMapper.deleteSensorInformationBySensorId(id);
        this.sensorMapper.deleteSensorById(id);
    }

    @Override
    public void updateSensor(Sensor sensor) {
        this.sensorMapper.updateSensor(sensor);
    }

    @Override
    public Sensor querySensorById(Integer id) {
        return this.sensorMapper.querySensorById(id);
    }

    @Override
    public List<Sensor> queryAllSensor() {
        return this.sensorMapper.queryAllSensor();
    }

    @Override
    public Sensor querySensorByName(String name) {
        return this.sensorMapper.querySensorByName(name);
    }

    @Override
    public void editSensorById(Integer id) {
        Sensor sensor = this.querySensorById(id);
        this.sensorMapper.editSensorById(sensor);
    }


}

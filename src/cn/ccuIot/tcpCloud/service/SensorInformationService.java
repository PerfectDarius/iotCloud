package cn.ccuIot.tcpCloud.service;

import cn.ccuIot.tcpCloud.entity.SensorInformation;

import java.util.List;

public interface SensorInformationService {

    List<SensorInformation> queryAllSensorInformation();    //查询所有消息记录

    List<SensorInformation> querySensorInformationByLikeMessage(String msg);   //根据关键字查询信息

    List<SensorInformation> querySensorInformationByLikeName(String name);      //根据设备名称查询

    void addSensorInformation(SensorInformation sensorInformation);
}

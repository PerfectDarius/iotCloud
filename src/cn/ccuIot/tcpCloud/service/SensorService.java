package cn.ccuIot.tcpCloud.service;

import cn.ccuIot.tcpCloud.entity.Sensor;

import java.util.List;

public interface SensorService {

    void addSensor(Sensor sensor);    //添加传感器

    void deleteSensorById(Integer id);  //根据查询id删除对应传感器

    void updateSensor(Sensor sensor);   //修改传感器

    Sensor querySensorById(Integer id);     //根据id查找传感器

    List<Sensor> queryAllSensor();      //查询全部传感器

    Sensor querySensorByName(String name);

    void editSensorById(Integer id);    //根据id更改传感器信息
}

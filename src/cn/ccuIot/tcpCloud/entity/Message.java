package cn.ccuIot.tcpCloud.entity;

import java.util.ArrayList;
import java.util.List;

public class Message {

    public static String SENSOR_RECEIVE_MSG;
    public static String[] SENSOR_RECEIVE_MSGs;
    public static String TEMP_SENSOR_RECEIVE_MSG = "Hello TEMP SENSOR";
    public static String MOBILE_RECEIVE_MSG = "Hello MOBILE";
    public static String TMP_SENSOR_MSG = "Hello TMP SENSOR";
    public static String TMP_MOBILE_MSG = "Hello TMP MOBILE";
    public static String CURRENT_SENSOR_INFORMATION = "Hello information";
    public static String WRITE_CURRENT_MESSAGE = "[{\"id\":0,\"sensor_id\":19,\"message\":\"0\",\"time\":\"0\",\"sensor\":{\"sensor_id\":19,\"sensor_ip\":\"0\",\"sensor_name\":\"0\",\"sensor_type\":\"0\",\"sensor_unit\":\"0\",\"isOnLine\":0}},{\"id\":0,\"sensor_id\":20,\"message\":\"0\",\"time\":\"0\",\"sensor\":{\"sensor_id\":20,\"sensor_ip\":\"0\",\"sensor_name\":\"0\",\"sensor_type\":\"0\",\"sensor_unit\":\"0\",\"isOnLine\":0}},{\"id\":0,\"sensor_id\":21,\"message\":\"0\",\"time\":\"0\",\"sensor\":{\"sensor_id\":21,\"sensor_ip\":\"0\",\"sensor_name\":\"0\",\"sensor_type\":\"0\",\"sensor_unit\":\"0\",\"isOnLine\":0}},{\"id\":0,\"sensor_id\":22,\"message\":\"0\",\"time\":\"0\",\"sensor\":{\"sensor_id\":22,\"sensor_ip\":\"0\",\"sensor_name\":\"0\",\"sensor_type\":\"0\",\"sensor_unit\":\"0\",\"isOnLine\":0}},{\"id\":0,\"sensor_id\":23,\"message\":\"0\",\"time\":\"0\",\"sensor\":{\"sensor_id\":23,\"sensor_ip\":\"0\",\"sensor_name\":\"0\",\"sensor_type\":\"0\",\"sensor_unit\":\"0\",\"isOnLine\":0}}]";

    public static List<SensorInformation> currentSensorInformationList;
    public static List<InformationVo> currentInformationVoList;

    static {
        SENSOR_RECEIVE_MSGs = new String[5];
        currentSensorInformationList = new ArrayList<>();
        currentInformationVoList = new ArrayList<>();

        /**
         * 可能没有用
         * */
        SensorInformation sensorInformation_T1 = new SensorInformation(0,19,"0","0",new Sensor(19,"0","0","0","0", 0));
        //大棚温度
        SensorInformation sensorInformation_T2 = new SensorInformation(0,20,"0","0",new Sensor(20,"0","0","0","0", 0));
        //土壤温度
        SensorInformation sensorInformation_L = new SensorInformation(0,21,"0","0",new Sensor(21,"0","0","0","0", 0));
        //大棚照明
        SensorInformation sensorInformation_S = new SensorInformation(0,22,"0","0",new Sensor(22,"0","0","0","0", 0));
        //土壤湿度
        SensorInformation sensorInformation_C = new SensorInformation(0,23,"0","0",new Sensor(23,"0","0","0","0", 0));
        //CO2浓度
        currentSensorInformationList.add(sensorInformation_T1);
        currentSensorInformationList.add(sensorInformation_T2);
        currentSensorInformationList.add(sensorInformation_L);
        currentSensorInformationList.add(sensorInformation_S);
        currentSensorInformationList.add(sensorInformation_C);

        InformationVo informationVo = new InformationVo();
        informationVo.setName("0");
        informationVo.setMessage("0");
        for (int i = 0; i < 5; i++) {
            currentInformationVoList.add(informationVo);
        }
        /**
         * 可能没有用
         * */
    }
}

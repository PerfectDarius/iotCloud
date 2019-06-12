//package cn.ccuIot.tcpCloud.util;
//
//import com.google.gson.Gson;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class JsonUtil {
//    public static void main(String[] args){
//
//        String str = "[{\"name\":\"T1\",\"message\":\"24\"},{\"name\":\"T2\",\"message\":\"56\"},{\"name\":\"H1\"," +
//                "\"message\":\"43\"},{\"name\":\"H2\",\"message\":\"77\"},{\"name\":\"I\",\"message\":\"89\"},{\"name\":\"C\",\"message\":\"14\"}]";
//        List<Demo> list = new JsonUtil().json2list(str);
//        for (Demo demo : list) {
//
//        }
//    }
//
//    public List<Demo> json2list(String str) {
//        Gson gson = new Gson();
//        List<Demo> resultList = new ArrayList<>();
//        List<Map<String,String>> list = gson.fromJson(str, List.class);
//        for (Map<String, String> map : list) {
//            String name = map.get("name");
//            String message = map.get("message");
//            resultList.add(new Demo(name, message));
//        }
//        for (Demo demo : resultList) {
//            System.out.println(demo);
//        }
//        return null;
//    }
//
//}

/**
 *if (!Message.TEMP_SENSOR_RECEIVE_MSG.equals(Message.SENSOR_RECEIVE_MSG)) {
 *             Message.TEMP_SENSOR_RECEIVE_MSG = Message.SENSOR_RECEIVE_MSG;
 *             Gson gson = new Gson();
 *             List<SensorVo> list = gson.fromJson(Message.SENSOR_RECEIVE_MSG, new TypeToken<List<SensorVo>>() {
 *             }.getType());
 *             for (SensorVo sensorVo : list) {
 *                 SensorInformation sensorInformation = new SensorInformation();
 *                 Sensor sensor = sensorService.querySensorByName(sensorVo.getName());
 *                 sensorInformation.setSensor(sensor);
 *                 sensorInformation.setTime(simpleDateFormat.format(new Date()));
 *                 sensorInformation.setMessage(sensorVo.getMessage());
 *                 sensorInformation.setSensor_id(sensor.getSensor_id());
 *                 sensorInformationService.addSensorInformation(sensorInformation);
 *                 currentList.add(sensorInformation);
 *             }
 *             Message.WRITE_CURRENT_MESSAGE = gson.toJson(currentList);
 *         }
 * */

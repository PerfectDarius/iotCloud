package cn.ccuIot.tcpCloud.entity;

public class Sensor {
    private int sensor_id;
    private String sensor_ip;
    private String sensor_name;
    private String sensor_type;
    private String sensor_unit;
    private int isOnLine;

    public Sensor() {
    }

    public Sensor(int sensor_id, String sensor_ip, String sensor_name, String sensor_type, String sensor_unit, int isOnLine) {
        this.sensor_id = sensor_id;
        this.sensor_ip = sensor_ip;
        this.sensor_name = sensor_name;
        this.sensor_type = sensor_type;
        this.sensor_unit = sensor_unit;
        this.isOnLine = isOnLine;
    }

    public int getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getSensor_ip() {
        return sensor_ip;
    }

    public void setSensor_ip(String sensor_ip) {
        this.sensor_ip = sensor_ip;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(String sensor_type) {
        this.sensor_type = sensor_type;
    }

    public String getSensor_unit() {
        return sensor_unit;
    }

    public void setSensor_unit(String sensor_unit) {
        this.sensor_unit = sensor_unit;
    }

    public int getIsOnLine() {
        return isOnLine;
    }

    public void setIsOnLine(int isOnLine) {
        this.isOnLine = isOnLine;
    }
}

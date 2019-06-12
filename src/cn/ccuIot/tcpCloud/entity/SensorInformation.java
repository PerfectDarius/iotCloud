package cn.ccuIot.tcpCloud.entity;

public class SensorInformation {
    private int id;
    private int sensor_id;
    private String message;
    private String time;
    private Sensor sensor;

    public SensorInformation() {
    }

    public SensorInformation(int id, int sensor_id, String message, String time, Sensor sensor) {
        this.id = id;
        this.sensor_id = sensor_id;
        this.message = message;
        this.time = time;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "SensorInformation{" +
                "id=" + id +
                ", sensor_id=" + sensor_id +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                ", sensor=" + sensor +
                '}';
    }
}

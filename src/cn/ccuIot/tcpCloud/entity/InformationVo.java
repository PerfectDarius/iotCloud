package cn.ccuIot.tcpCloud.entity;

public class InformationVo {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InformationVo{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

package cn.lhqs.viewModel;

import java.io.Serializable;
import java.util.Date;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-22 17:27
 * description : NodeDataView.class
 * version : 1.0
 */
public class NodeDataView implements Serializable{
    private Integer id;
    /**
     * 土壤温度
     */
    private double ground;

    /**
     * 湿度
     */
    private double humidity;

    /**
     * 叶片温度
     */
    private double temperature;

    /**
     * PH值
     */
    private double ph;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getGround() {
        return ground;
    }

    public void setGround(double ground) {
        this.ground = ground;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

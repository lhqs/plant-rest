package cn.lhqs.model;

import java.io.Serializable;
import java.util.Date;


public class DataInfo implements Serializable {
    /**
     * 源数据id
     */
    private Integer id;

    /**
     * 空气湿度
     */
    private double humidity;

    /**
     * 空气温度
     */
    private double temperature;

    /**
     * 光照强度
     */
    private double illumination;

    private double carbon;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getIllumination() {
        return illumination;
    }

    public void setIllumination(double illumination) {
        this.illumination = illumination;
    }

    public double getCarbon() {
        return carbon;
    }

    public void setCarbon(double carbon) {
        this.carbon = carbon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
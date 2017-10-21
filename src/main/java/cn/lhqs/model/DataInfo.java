package cn.lhqs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class DataInfo implements Serializable {
    /**
     * 源数据id
     */
    private Integer id;

    /**
     * 空气湿度
     */
    private Integer humidity;

    /**
     * 空气温度
     */
    private Integer temperature;

    /**
     * 光照强度
     */
    private Integer illumination;

    private String carbon;

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

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getIllumination() {
        return illumination;
    }

    public void setIllumination(Integer illumination) {
        this.illumination = illumination;
    }

    public String getCarbon() {
        return carbon;
    }

    public void setCarbon(String carbon) {
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
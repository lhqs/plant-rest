package cn.lhqs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class NodeZero implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 主键关联
     */
    private Integer pid;

    /**
     * 土壤温度
     */
    private String ground;

    /**
     * 湿度
     */
    private String humidity;

    /**
     * 叶片温度
     */
    private String temperature;

    /**
     * PH值
     */
    private String ph;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
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
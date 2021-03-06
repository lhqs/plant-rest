package cn.lhqs.model;

import java.io.Serializable;
import java.util.Date;

public class MembershipInfo implements Serializable {
    private Integer id;

    private String authId;

    private String username;

    private String password;

    /**
     * 1:有效   0：无效
     */
    private int status;

    private String mobilePhone;

    private String email;

    private String createName;

    private Date createTime;

    private String updateName;

    private Date updateTime;


    private String sensorOne;
    private String sensorTwo;
    private String sensorThree;

    private String orgName;

    private String homeDir;
    private String imageUrl;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getHomeDir() {
        return homeDir;
    }

    public void setHomeDir(String homeDir) {
        this.homeDir = homeDir;
    }

    public String getSensorOne() {
        return sensorOne;
    }

    public void setSensorOne(String sensorOne) {
        this.sensorOne = sensorOne;
    }

    public String getSensorTwo() {
        return sensorTwo;
    }

    public void setSensorTwo(String sensorTwo) {
        this.sensorTwo = sensorTwo;
    }

    public String getSensorThree() {
        return sensorThree;
    }

    public void setSensorThree(String sensorThree) {
        this.sensorThree = sensorThree;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MembershipInfo{" +
                "id=" + id +
                ", authId='" + authId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", updateName='" + updateName + '\'' +
                ", updateTime=" + updateTime +
                ", sensorOne='" + sensorOne + '\'' +
                ", sensorTwo='" + sensorTwo + '\'' +
                ", sensorThree='" + sensorThree + '\'' +
                ", orgName='" + orgName + '\'' +
                ", homeDir='" + homeDir + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
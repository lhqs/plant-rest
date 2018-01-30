package cn.lhqs.viewModel;


import java.util.Date;

/**
 * author : lhqs
 * description : 前端传输实体类
 * createTime : 2018-01-08 17:01
 * version : 1.0
 */
public class UserInfo {
    private Integer id;
    private String authId;

    private String username;
    private String password;
    private int status;
    private String sensorOne;
    private String sensorTwo;
    private String sensorThree;
    private String mobilePhone;



    private Date createTime;

    private Date updateTime;

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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", authId='" + authId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", sensorOne='" + sensorOne + '\'' +
                ", sensorTwo='" + sensorTwo + '\'' +
                ", sensorThree='" + sensorThree + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orgName='" + orgName + '\'' +
                ", homeDir='" + homeDir + '\'' +", imageUrl=" + imageUrl + '\''+
        '}';
    }
}

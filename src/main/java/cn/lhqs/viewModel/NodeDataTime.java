package cn.lhqs.viewModel;


/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-24 18:50
 * description : NodeDataTime.class
 * version : 1.0
 */
public class NodeDataTime {
    private String startDatetime;
    private String endDatetime;

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    @Override
    public String toString() {
        return "NodeDataTime{" +
                "startDatetime=" + startDatetime +
                ", endDatetime=" + endDatetime +
                '}';
    }


}

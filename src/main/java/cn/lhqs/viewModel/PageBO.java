package cn.lhqs.viewModel;

import java.util.List;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-25 20:45
 * description : 分页
 * version : 1.0
 */
public class PageBO<T> {

    private Long total;

    private List<T> list;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
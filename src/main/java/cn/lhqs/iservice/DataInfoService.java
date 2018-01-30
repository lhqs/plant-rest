package cn.lhqs.iservice;

import cn.lhqs.model.DataInfo;

import java.util.List;

/**
 * author : lhqs
 * description : 数据获取接口
 * createTime : 2017-12-19 19:15
 * version : 1.0
 */
public interface DataInfoService {

    List<DataInfo> getDataInfoList();

    List<DataInfo> getDataInfoForNum();

    DataInfo getRealDataForOne();

}

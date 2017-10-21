package cn.lhqs.iservice;

import cn.lhqs.model.DataInfo;

import java.util.List;

public interface DataInfoService {

    List<DataInfo> getDataInfoList();

    List<DataInfo> getDataInfoForNum();

}

package cn.lhqs.service;

import cn.lhqs.dao.DataInfoMapper;
import cn.lhqs.iservice.DataInfoService;
import cn.lhqs.model.DataInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataInfoServiceImpl implements DataInfoService {

    @Resource
    DataInfoMapper dataInfoMapper;



    public List<DataInfo> getDataInfoList() {
        List<DataInfo> dataList = dataInfoMapper.getAllDataInfo();
        return dataList;

    }

    public List<DataInfo> getDataInfoForNum() {
        return dataInfoMapper.getDataInfoForNum();
    }
}

package cn.lhqs.service;

import cn.lhqs.dao.DataInfoMapper;
import cn.lhqs.iservice.DataInfoService;
import cn.lhqs.model.DataInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author : lhqs
 * description : 数据获取实现类
 * createTime : 2017-12-19 19:15
 * version : 1.0
 */
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

    @Override
    public DataInfo getRealDataForOne() {
        return dataInfoMapper.getRealData();
    }
}

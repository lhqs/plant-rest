package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.DataInfoService;
import cn.lhqs.model.DataInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author : lhqs
 * description : 生产数据
 * createTime : 2018-01-04 10:09
 * version : 1.0
 */
@RestController
@RequestMapping(value = "api")
public class DataInfoController {

    public static Logger logger = LoggerFactory.getLogger(DataInfoController.class);

    @Resource
    DataInfoService dataInfoServiceImpl;

    @Value("${TOKEN}")
    private String TOKEN;

    /**
     * 获取所有数据
     * @return
     */
    @GetMapping(value = "getAllDataInfo")
    public ResponseResult getAllDataInfo() {
        List<DataInfo> dataInfoList = dataInfoServiceImpl.getDataInfoList();
        return new ResponseResult(0,"success",dataInfoList);
    }

    /**
     * 获取固定数量的数据
     */
    @GetMapping(value = "getDataInfoNum")
    public ResponseResult getDataInfoNum(HttpServletRequest request) {
        List<DataInfo> dataInfoNum = dataInfoServiceImpl.getDataInfoForNum();
        return new ResponseResult(0, "success", dataInfoNum);
    }

    /**
     * 获取当前最新一条数据（实时数据）
     * @return
     */
    @GetMapping(value = "getRealData")
    public ResponseResult getRealData(){
        DataInfo realDataForOne = dataInfoServiceImpl.getRealDataForOne();
        return new ResponseResult(0, "success", realDataForOne);
    }


}

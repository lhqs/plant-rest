package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.DataInfoService;
import cn.lhqs.model.DataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 生产数据
 */

@RestController
@RequestMapping(value = "api")
public class DataInfoController {

    @Resource
    DataInfoService dataInfoServiceImpl;

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
}

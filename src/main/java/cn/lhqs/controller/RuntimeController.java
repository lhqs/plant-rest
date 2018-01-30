package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * author : lhqs
 * description : 系统运行环境监测
 * createTime : 2018-01-07 14:28
 * version : 1.0
 */
@RestController
@RequestMapping(value = "api")
public class RuntimeController {

    public static Logger logger = LoggerFactory.getLogger(RuntimeController.class);

    @Resource
    RuntimeService runtimeServiceImpl;


    /**
     * 获取系统运行环境(Map)
     * @return
     */
    @GetMapping(value = "getRuntimeStatus")
    public ResponseResult getAllDataInfo() {
        Map<String, String> runtimeMap = runtimeServiceImpl.getRuntimeMap();
        return new ResponseResult(0,"success",runtimeMap);
    }

    /**
     * 获取系统运行环境(List)
     * @return
     */
    @GetMapping(value = "getRuntimeStatusList")
    public ResponseResult getAllDataInfoList() {
        List<String> runtimeList = runtimeServiceImpl.getRuntimeList();
        return new ResponseResult(0,"success",runtimeList);
    }
}

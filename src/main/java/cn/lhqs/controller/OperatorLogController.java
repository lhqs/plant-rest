package cn.lhqs.controller;


import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.OperatorLogService;
import cn.lhqs.model.OperatorLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志管理
 */
@RestController
@RequestMapping(value = "api")
public class OperatorLogController {

    @Resource
    OperatorLogService operatorLogServiceImpl;

    /**
     * 获取所有的日志内容
     * @return
     */
    @GetMapping(value = "/getAllOperatorLog")
    public ResponseResult getAllOperatorLog() {
        List<OperatorLog> loglist = operatorLogServiceImpl.getAllOperatorLogList();
        return new ResponseResult(0, "success", loglist);
    }


}

package cn.lhqs.controller;


import cn.lhqs.common.ResponseResult;
import cn.lhqs.iservice.OperatorLogService;
import cn.lhqs.model.OperatorLog;
import cn.lhqs.viewModel.PageBO;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * author : lhqs
 * description : 日志管理
 * createTime : 2017-12-26 20:43
 * version : 1.0
 */
@RestController
@RequestMapping(value = "api")
public class OperatorLogController {
    private static Logger logger = LoggerFactory.getLogger(MembershipInfoController.class);

    @Resource
    OperatorLogService operatorLogServiceImpl;

    /**
     * 获取所有的日志内容
     *
     * @return
     */
    @GetMapping(value = "/getAllOperatorLog")
    public ResponseResult getAllOperatorLog(@RequestParam(value = "pageNum", defaultValue = "1")int pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "10")int pageSize) {
        PageBO<OperatorLog> loglist = operatorLogServiceImpl.getAllOperatorLogList(pageNum, pageSize);
        return new ResponseResult(0, "success", loglist);
    }

    /**
     * 移除操作日志记录
     */
    @DeleteMapping(value = "/removeOperatorLog")
    public ResponseResult removeOperatorLog(@Param("id") int id) {
        logger.info("the delete id ----> " + id);
        int respCode = operatorLogServiceImpl.deleteOperatorLog(id);
        if (respCode != 0) {
            return ResponseResult.ok;
        } else {
            return ResponseResult.fail;
        }

    }
}


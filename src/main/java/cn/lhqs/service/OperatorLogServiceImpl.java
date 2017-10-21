package cn.lhqs.service;

import cn.lhqs.dao.OperatorLogMapper;
import cn.lhqs.iservice.OperatorLogService;
import cn.lhqs.model.OperatorLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperatorLogServiceImpl implements OperatorLogService{

    @Resource
    OperatorLogMapper operatorLogMapper;

    public List<OperatorLog> getAllOperatorLogList() {
        List<OperatorLog> allOperatorLogList = operatorLogMapper.getAllOperatorLogList();
        return allOperatorLogList;
    }
}

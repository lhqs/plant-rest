package cn.lhqs.service;

import cn.lhqs.dao.OperatorLogMapper;
import cn.lhqs.iservice.OperatorLogService;
import cn.lhqs.model.OperatorLog;
import cn.lhqs.viewModel.PageBO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author : lhqs
 * description : 管理员操作日志实现类
 * createTime : 2017-12-19 18:37
 * version : 1.0
 */
@Service
public class OperatorLogServiceImpl implements OperatorLogService{

    @Resource
    OperatorLogMapper operatorLogMapper;

    /**
     * 获取所有的日志操作记录
     * @return
     */
    public PageBO<OperatorLog> getAllOperatorLogList(int pageNum, int pageSize) {
        PageBO<OperatorLog> pageBO = new PageBO<>();
        Page<OperatorLog> page = PageHelper.startPage(pageNum, pageSize);

        List<OperatorLog> allOperatorLogList = operatorLogMapper.getAllOperatorLogList();
        pageBO.setTotal(page.getTotal());
        pageBO.setList(allOperatorLogList);
        return pageBO;
    }

    @Override
    public int deleteOperatorLog(int id) {
        int respCode = operatorLogMapper.deleteByPrimaryKey(id);
        return respCode;
    }
}

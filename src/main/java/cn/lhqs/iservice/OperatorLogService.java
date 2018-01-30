package cn.lhqs.iservice;

import cn.lhqs.model.OperatorLog;
import cn.lhqs.viewModel.PageBO;

import java.util.List;

/**
 * author : lhqs
 * description : 管理员操作日志接口
 * createTime : 2017-12-19 18:37
 * version : 1.0
 */
public interface OperatorLogService {

    /**
     * 获取操作日志列表
     * @return
     */
    PageBO<OperatorLog> getAllOperatorLogList(int pageNum, int pageSize);

    /**
     * 移除操作日志记录
     * @param id
     * @return
     */
    int deleteOperatorLog(int id);

}

package cn.lhqs.dao;

import cn.lhqs.model.OperatorLog;
import cn.lhqs.model.OperatorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorLogMapper {
    long countByExample(OperatorLogExample example);

    int deleteByExample(OperatorLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperatorLog record);

    int insertSelective(OperatorLog record);

    List<OperatorLog> selectByExampleWithBLOBs(OperatorLogExample example);

    List<OperatorLog> selectByExample(OperatorLogExample example);

    OperatorLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperatorLog record, @Param("example") OperatorLogExample example);

    int updateByExampleWithBLOBs(@Param("record") OperatorLog record, @Param("example") OperatorLogExample example);

    int updateByExample(@Param("record") OperatorLog record, @Param("example") OperatorLogExample example);

    int updateByPrimaryKeySelective(OperatorLog record);

    int updateByPrimaryKeyWithBLOBs(OperatorLog record);

    int updateByPrimaryKey(OperatorLog record);

    /**
     * 获取所有日志内容
     */
    List<OperatorLog> getAllOperatorLogList();
}
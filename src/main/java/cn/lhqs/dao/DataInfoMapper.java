package cn.lhqs.dao;

import cn.lhqs.model.DataInfo;
import cn.lhqs.model.DataInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataInfoMapper {

    long countByExample(DataInfoExample example);

    int deleteByExample(DataInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DataInfo record);

    int insertSelective(DataInfo record);

    List<DataInfo> selectByExample(DataInfoExample example);

    DataInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DataInfo record, @Param("example") DataInfoExample example);

    int updateByExample(@Param("record") DataInfo record, @Param("example") DataInfoExample example);

    int updateByPrimaryKeySelective(DataInfo record);

    int updateByPrimaryKey(DataInfo record);

    /**
     * 获取所有的数据
     */
    List<DataInfo> getAllDataInfo();

    /**
     * 获取指定条数的数据
     */
    List<DataInfo> getDataInfoForNum();

    /**
     * 获取当前最近的一条数据
     * @return
     */
    DataInfo getRealData();


}
package cn.lhqs.dao;

import cn.lhqs.model.NodeZero;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NodeZeroMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NodeZero record);

    int insertSelective(NodeZero record);

    NodeZero selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NodeZero record);

    int updateByPrimaryKey(NodeZero record);

    /**
     * 获取最新指定条数的数据(node_zero)
     * @return
     */
    List<NodeZero> selectNumByNodeZero(@Param("num") Integer num);

    /**
     * 获取最新指定条数的数据(node_one)
     * @return
     */
    List<NodeZero> selectNumByNodeOne(@Param("num") Integer num);

    /**
     * 获取最新指定条数的数据(node_three)
     * @return
     */
    List<NodeZero> selectNumByNodeThree(@Param("num") Integer num);

    /**
     * 获取节点一的数据
     * @param startDatetime
     * @param endDatetime
     * @return
     */
    List<NodeZero> selectDataForNodeOne(@Param("startDatetime") LocalDateTime startDatetime, @Param("endDatetime")LocalDateTime endDatetime);

    /**
     * 获取节点二的数据
     * @param startDatetime
     * @param endDatetime
     * @return
     */
    List<NodeZero> selectDataForNodeTwo(@Param("startDatetime") LocalDateTime startDatetime, @Param("endDatetime") LocalDateTime endDatetime);

    /**
     * 获取节点三的数据
     * @param startDatetime
     * @param endDatetime
     * @return
     */
    List<NodeZero> selectDataForNodeThree(@Param("startDatetime") LocalDateTime startDatetime, @Param("endDatetime")LocalDateTime endDatetime);



}
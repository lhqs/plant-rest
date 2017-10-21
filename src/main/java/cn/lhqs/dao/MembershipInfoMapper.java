package cn.lhqs.dao;

import cn.lhqs.model.MembershipInfo;
import cn.lhqs.model.MembershipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;

public interface MembershipInfoMapper {
    long countByExample(MembershipInfoExample example);

    int deleteByExample(MembershipInfoExample example);

    int insert(MembershipInfo record);

    List<MembershipInfo> selectByExample(MembershipInfoExample example);

    MembershipInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MembershipInfo record, @Param("example") MembershipInfoExample example);

    int updateByExample(@Param("record") MembershipInfo record, @Param("example") MembershipInfoExample example);

    int updateByPrimaryKey(MembershipInfo record);

    /**
     * 获取所有的管理员信息
     * @return
     */
    List<MembershipInfo> getAllMembershipInfo();

    /**
     * 添加用户
     * @param record
     * @return
     */
    int insertSelective(MembershipInfo record);


    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(MembershipInfo record);

    /**
     * 判断用户信息是否匹配
     * @param username
     * @param password
     * @return
     */
    int getMembershipInfoCount(@Param("username")String username,@Param("password")String password);

    /**
     * 判断是否存在此用户
     */
    int getUserCount(@Param("username") String username);
}
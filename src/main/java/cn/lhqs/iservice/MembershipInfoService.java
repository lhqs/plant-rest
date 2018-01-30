package cn.lhqs.iservice;

import cn.lhqs.model.MembershipInfo;
import cn.lhqs.viewModel.PageBO;

import java.util.List;

/**
 * author : lhqs
 * description : 用户接口
 * createTime : 2017-09-09 11:07
 * version : 1.0
 */
public interface MembershipInfoService {

    /**
     * 获取所有用户信息列表
     * @return
     */
    PageBO<MembershipInfo> getAllMembershipInfo(int pageNum, int pageSize);


    /**
     * 删除用户相关信息
     * @param authId
     * @return
     */
    int removeUser(String authId,String deleteName,String username);


    /**
     * 编辑用户信息
     * @param membershipInfo
     * @return
     */
    int updateUser(MembershipInfo membershipInfo,String updateName);

    /**
     * 判断用户信息是否匹配
     * @param membershipInfo
     * @return
     */
    int getUserInfo(MembershipInfo membershipInfo);

    /**
     * 判断是否存在usernamey用户
     * @param username
     * @return
     */
    int getUserCount(String username);


    /**
     * 获取用户登录信息详情
     * @param membershipInfo
     * @return
     */
    MembershipInfo getUserInfoDetails(MembershipInfo membershipInfo);

    /**
     * 添加用户信息与所属权限
     * @param membershipInfo
     * @return
     */
    int addUserInfo(MembershipInfo membershipInfo , String createUser);

    /**
     * 根据username查询用户信息
     * @param username
     * @return
     */
    List<MembershipInfo> getMembershipInfoByUsername(String username);
}

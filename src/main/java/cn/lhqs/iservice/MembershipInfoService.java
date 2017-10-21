package cn.lhqs.iservice;

import cn.lhqs.model.MembershipInfo;

import java.util.List;

public interface MembershipInfoService {

    List<MembershipInfo> getAllMembershipInfo();

    int removeUser(int id);

    int addUser(MembershipInfo membershipInfo);

    int updateUser(MembershipInfo membershipInfo);

    int getUserInfo(MembershipInfo membershipInfo);

    int getUserCount(String username);
}

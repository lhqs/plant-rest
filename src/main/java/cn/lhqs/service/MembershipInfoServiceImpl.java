package cn.lhqs.service;

import cn.lhqs.dao.MembershipInfoMapper;
import cn.lhqs.iservice.MembershipInfoService;
import cn.lhqs.model.MembershipInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MembershipInfoServiceImpl implements MembershipInfoService {

    @Resource
    MembershipInfoMapper membershipInfoMapper;

    public List<MembershipInfo> getAllMembershipInfo() {
        List<MembershipInfo> memberList = membershipInfoMapper.getAllMembershipInfo();
        return memberList;
    }

    public int removeUser(int id) {
        int result = membershipInfoMapper.deleteByPrimaryKey(id);
        return result;
    }

    public int addUser(MembershipInfo membershipInfo) {
        return membershipInfoMapper.insertSelective(membershipInfo);
    }

    public int updateUser(MembershipInfo membershipInfo) {
        return membershipInfoMapper.updateByPrimaryKeySelective(membershipInfo);
    }

    public int getUserInfo(MembershipInfo membershipInfo) {
        return membershipInfoMapper.getMembershipInfoCount(membershipInfo.getUsername(),membershipInfo.getPassword());
    }

    public int getUserCount(String username) {
        return membershipInfoMapper.getUserCount(username);
    }
}

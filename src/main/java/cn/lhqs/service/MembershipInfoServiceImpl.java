package cn.lhqs.service;

import cn.lhqs.common.BeanCopyUtils;
import cn.lhqs.common.PropertiesUtil;
import cn.lhqs.dao.MembershipInfoMapper;
import cn.lhqs.dao.OperatorLogMapper;
import cn.lhqs.iservice.MembershipInfoService;
import cn.lhqs.model.MembershipInfo;
import cn.lhqs.model.OperatorLog;
import cn.lhqs.viewModel.PageBO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author : lhqs
 * description : 用户接口实现类
 * createTime : 2017-09-09 11:07
 * version : 1.0
 */
@Service
public class MembershipInfoServiceImpl implements MembershipInfoService {

    private static Logger logger = LoggerFactory.getLogger(MembershipInfoServiceImpl.class);

    // @Value("${ImageUrl}")
    // String ImageUrl;

    private static final String imageUrl = PropertiesUtil.getProperty("ImageUrl");

    @Resource
    OperatorLogMapper operatorLogMapper;

    @Transactional
    @Override
    public int removeUser(String authId,String deleteName,String username) {
        int result = membershipInfoMapper.deleteByAuthId(authId);
        int resultCode = membershipInfoMapper.deleteByAuthIdSensor(authId);
        OperatorLog operatorLog = new OperatorLog();
        operatorLog.setOperatorUser(deleteName);
        operatorLog.setOperatorTime(new Date());
        operatorLog.setContent("删除用户:" + username);
        operatorLogMapper.insertSelective(operatorLog);
        return result + resultCode;
    }

    @Resource
    MembershipInfoMapper membershipInfoMapper;

    public PageBO<MembershipInfo> getAllMembershipInfo(int pageNum, int pageSize) {
        PageBO<MembershipInfo> pageBOs = new PageBO<>();

        Page<MembershipInfo> page = PageHelper.startPage(pageNum, pageSize);

        List<MembershipInfo> memberList = membershipInfoMapper.getAllMembershipInfo();

        List<MembershipInfo> viewList = new ArrayList<>();
        for(MembershipInfo viewMember : memberList){
            MembershipInfo member = new MembershipInfo();
            BeanCopyUtils.copyProperties(viewMember,member);
            member.setImageUrl(imageUrl+"/"+viewMember.getImageUrl());
            viewList.add(member);
        }

        pageBOs.setList(viewList);
        pageBOs.setTotal(page.getTotal());
        return pageBOs;
    }

    @Transactional
    @Override
    public int updateUser(MembershipInfo membershipInfo, String updateName) {
        int respCode = membershipInfoMapper.updateByPrimaryKeySelective(membershipInfo);
        int respCodes = membershipInfoMapper.updateByPrimaryKeySensorLimit(membershipInfo);
        logger.info("respCode-->"+respCode+" ;  respCodes--->"+respCodes);
        OperatorLog operatorLog = new OperatorLog();
        operatorLog.setOperatorUser(updateName);
        operatorLog.setOperatorTime(new Date());
        operatorLog.setContent("更新用户:"+membershipInfo.getUsername());
        operatorLogMapper.insertSelective(operatorLog);
        return respCode + respCodes;
    }


    @Override
    public int getUserInfo(MembershipInfo membershipInfo) {

        return membershipInfoMapper.getMembershipInfoCount(membershipInfo.getUsername(),membershipInfo.getPassword());
    }

    @Override
    public int getUserCount(String username) {
        return membershipInfoMapper.getUserCount(username);
    }

    @Override
    public MembershipInfo getUserInfoDetails(MembershipInfo membershipInfo) {
        MembershipInfo member = membershipInfoMapper.selectUserDatails(membershipInfo.getUsername(), membershipInfo.getPassword());
        member.setImageUrl(imageUrl+"/"+member.getImageUrl());
        return member;
    }

    @Override
    @Transactional
    public int addUserInfo(MembershipInfo membershipInfo, String createUser) {
        int resCode = membershipInfoMapper.insertSelective(membershipInfo);
        int resCodes = membershipInfoMapper.insertSensorLimit(membershipInfo);
        OperatorLog operatorLog = new OperatorLog();
        operatorLog.setOperatorUser(createUser);
        operatorLog.setOperatorTime(new Date());
        operatorLog.setContent("添加用户:"+membershipInfo.getUsername());
        operatorLogMapper.insertSelective(operatorLog);
        return resCode + resCodes;
    }

    @Override
    public List<MembershipInfo> getMembershipInfoByUsername(String username) {
        List<MembershipInfo> memberList = membershipInfoMapper.selectMembershipInfoByUsername(username);
        return memberList;
    }
}

package cn.lhqs.test;

import cn.lhqs.dao.DataInfoMapper;
import cn.lhqs.dao.MembershipInfoMapper;
import cn.lhqs.model.DataInfo;
import cn.lhqs.model.MembershipInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(value = SpringJUnit4ClassRunner.class) // 添加spring测试方案
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class FirstTest {

//    ApplicationContext ic =  new  ClassPathXmlApplicationContext("applicationContext.xml");


    @Resource
    MembershipInfoMapper membershipInfoMapper;

    @Test
    public void getAllMembershipInfo() {
        List<MembershipInfo> memberList = membershipInfoMapper.getAllMembershipInfo();
        System.out.println(memberList.get(0).getUsername());
    }



}

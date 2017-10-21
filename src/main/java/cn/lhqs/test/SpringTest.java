package cn.lhqs.test;


import cn.lhqs.dao.MembershipInfoMapper;
import cn.lhqs.model.MembershipInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(value = SpringJUnit4ClassRunner.class)// 添加spring测试方案
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})// 指定spring配置文件位置
public class SpringTest {

//    @Resource

//    DataInfoMapper dataInfoMapper;
    @Resource
MembershipInfoMapper membershipInfoMapper;

    @Test
    public void getDataInfoList() {
        MembershipInfo dataList = membershipInfoMapper.selectByPrimaryKey(1);
        System.out.println(dataList.getUsername());


    }



}

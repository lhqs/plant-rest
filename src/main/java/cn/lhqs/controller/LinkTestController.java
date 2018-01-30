package cn.lhqs.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * author : lhqs
 * description : 链接测试link_test
 * createTime : 2017-10-24 16:03
 * version : 1.0
 */
@RestController
@RequestMapping(value = "api")
public class LinkTestController {

    /**
     * 测试tomcat是否可以正常提供服务
     * @param request
     * @return
     */
    @GetMapping(value = "test")
    public String testReturn(HttpServletRequest request) {
        System.out.println("test successed");
        return "test successed";
    }

    /**
     * 获取传感器节点访问权限（temp_test）
     * @return
     */
    @GetMapping(value = "getSensorLimit")
    public String testLimit(){
        return "001";
    }
}

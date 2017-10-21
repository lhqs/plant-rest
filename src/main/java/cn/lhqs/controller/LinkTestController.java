package cn.lhqs.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}

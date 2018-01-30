package cn.lhqs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author : lhqs
 * description : 跨域请求过滤器
 * createTime : 2018-01-04 10:09
 * version : 1.0
 */
public class CORSFilter implements Filter {

    public static Logger logger = LoggerFactory.getLogger(CORSFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest requ = (HttpServletRequest) servletRequest;
        // response.setHeader("Access-Control-Allow-Origin", "http://localhost:8023");
        // response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8023");
        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");
        // response.setHeader("Access-Control-Allow-Origin", "http://plant.lhqs1314.cn");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(requ, response);
    }


    public void destroy() {

    }
}

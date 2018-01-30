package cn.lhqs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author : lhqs
 * description : ProcessInterceptor.class
 * createTime : 2018-01-10 10:09
 * version : 1.0
 */
public class ProcessInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(ProcessInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
        httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        httpServletResponse.setHeader("X-Powered-By","Jetty");
        String method= httpServletRequest.getMethod();
        if (method.equals("OPTIONS")){
            httpServletResponse.setStatus(200);
            return false;
        }
        logger.info("method--->" + method);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

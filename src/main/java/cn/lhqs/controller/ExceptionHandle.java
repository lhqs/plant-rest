package cn.lhqs.controller;

import cn.lhqs.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * author : lhqs
 * description : 全局异常处理类
 * createTime : 2017-10-24 16:03
 * version : 1.0
 */
@RestControllerAdvice
public class ExceptionHandle {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    ResponseResult UNKNOWN_ERROR = new ResponseResult(-3,"未知异常");
    ResponseResult RUNTIME_ERROR = new ResponseResult(-4, "未知运行异常");

    /**
     * 处理意想不到的运行时异常
     * @param request
     * @param ex
     */
    @ExceptionHandler({RuntimeException.class})
    public ResponseResult handleRuntimeException(HttpServletRequest request,
                                                 RuntimeException ex) {
        ex.printStackTrace();
        logger.error("未知运行异常\r\n" + ex.getMessage(), ex);
        return RUNTIME_ERROR;
    }

    /**
     * 处理任何异常
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseResult handleException(HttpServletRequest request,
                                            Exception ex) {
        ex.printStackTrace();
        logger.error("未知异常", ex);
        return UNKNOWN_ERROR;
    }
}

package com.bran.admin.exception;

import com.bran.admin.common.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * desc:处理自定义异常
     **/
    @ExceptionHandler(value = CheckException.class)
    public ResultBean<String> exceptionHandler(CheckException e) {
        return ResultBean.error(e.getMessage());
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResultBean<String> exceptionHandler(Exception ex) {
        log.error("HttpMessageNotReadableException ==> :{}", ex.getLocalizedMessage(), ex);
        String errMsg = ex.getLocalizedMessage();
        if (StringUtils.hasText(errMsg) && errMsg.contains("body is missing")) {
            return ResultBean.error("参数必传,请检查请求 body 参数!");
        } else {
            return ResultBean.error(errMsg);
        }
    }

    @ExceptionHandler(value = Exception.class)
    public ResultBean<String> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("ZxspException==>{}", e.getMessage(), e);
        if (StringUtils.hasText(e.getLocalizedMessage())) {
            return ResultBean.error(e.getLocalizedMessage());
        } else {
            return ResultBean.error(e.getMessage());
        }
    }
}

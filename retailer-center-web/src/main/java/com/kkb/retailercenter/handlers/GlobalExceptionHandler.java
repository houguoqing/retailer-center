package com.kkb.retailercenter.handlers;

import com.kkb.retailer.center.common.http.DefinitionException;
import com.kkb.retailer.center.common.http.HttpResult;
import com.kkb.retailer.center.common.http.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //开启全局异常捕获拦截
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常信息
     * @param e
     * @return
     * */
    @ExceptionHandler(value = DefinitionException.class)
    public HttpResult<Object> customExceptionHandler(DefinitionException e){
        return HttpResult.defineError(e);
    }
    /**
     * 处理其他异常信息
     * @param e
     * @return
     * */
    @ExceptionHandler(value = Exception.class)
    public HttpResult<Object> excetionHandler(Exception e){
        if(e instanceof NullPointerException){
            return  HttpResult.otherError(ResultEnum.NO_AUTH);
        }else if(e instanceof IllegalAccessException){
            return HttpResult.otherError(ResultEnum.NO_PERMISSION);
        }else {
            return HttpResult.otherError(ResultEnum.SERVER_ERROR);
        }
    }
}

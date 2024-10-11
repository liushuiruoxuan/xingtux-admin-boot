package com.xt.common.exception;

import com.xt.common.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hongxuanchai
 */
@Slf4j
@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public GlobalExceptionHandler() {
    }

    public void doSomething(Exception e, HttpServletRequest request) {
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseResult handleHttpMessageNotReadableException(Exception e, HttpServletRequest request) {
        this.doSomething(e, request);
        this.logger.warn("400-参数解析失败,{},{}", e.getMessage(), request.getServletPath());
        return ResponseResult.error("参数解析失败");
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseResult handleHttpRequestMethodNotSupportedException(Exception e, HttpServletRequest request) {
        this.doSomething(e, request);
        this.logger.warn("405-不支持当前请求方法,{},{}", e.getMessage(), request.getServletPath());
        return ResponseResult.error("不支持当前请求方法");
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseResult handleHttpMediaTypeNotSupportedException(Exception e, HttpServletRequest request) {
        this.doSomething(e, request);
        this.logger.warn("415-不支持当前媒体类型,{},{}", e.getMessage(), request.getServletPath());
        return ResponseResult.error("不支持当前媒体类型");
    }

    @ExceptionHandler({Exception.class})
    public ResponseResult handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        this.doSomething(e, request);
        if (e instanceof BusinessException) {
            if (e.getCause() == null) {
                this.logger.warn("业务提示,{},{}", e.getMessage(), request.getServletPath());
                response.setStatus(200);
            } else {
                this.logger.error("业务异常," + request.getServletPath(), e);
                response.setStatus(500);
            }

            return ResponseResult.error(e.getMessage());
        } else {
            this.logger.error("系统异常," + request.getServletPath(), e);
            response.setStatus(500);
            return ResponseResult.error("系统异常");
        }
    }

}
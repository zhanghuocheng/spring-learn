package com.example.javaspringboot.aop;

import com.example.javaspringboot.Model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ExceptionAop {

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse viewExceptionHandler(HttpServletRequest req, RuntimeException e) {
        log.error(e.getMessage());
        return new BaseResponse("系统异常", 00001);
    }
}

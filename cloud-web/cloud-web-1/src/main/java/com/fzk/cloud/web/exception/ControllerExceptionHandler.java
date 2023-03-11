package com.fzk.cloud.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 控制器内异常处理类
 */
@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object exceptionHandle(Exception e) {
        log.error("controller异常：{}", e.getLocalizedMessage());
        return new ResponseEntity("服务异常！", HttpStatus.OK);
    }
    // todo 如有自定义业务异常类可在下面追加
}

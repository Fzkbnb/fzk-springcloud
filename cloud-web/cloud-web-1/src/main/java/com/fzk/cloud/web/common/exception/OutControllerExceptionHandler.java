package com.fzk.cloud.web.common.exception;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器外异常处理类 另一种处理方式：实现ErrorController方式不建议使用，因为会丢失部分异常信息
 */
@Slf4j
@Component
public class OutControllerExceptionHandler implements ErrorViewResolver {
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        Map<String, Object> map = new HashMap();
        map.put("request", request);
        map.put("model", model);
        map.put("status", status.value());
        log.error("controller外部请求异常：{}",model.toString());
        return new ModelAndView("服务异常！", map, HttpStatus.OK);
    }

}

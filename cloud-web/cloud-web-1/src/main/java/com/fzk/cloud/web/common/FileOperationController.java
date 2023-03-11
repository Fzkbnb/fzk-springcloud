package com.fzk.cloud.web.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/common")
public class FileOperationController {

    @Autowired
    TemplateEngine templateEngine;
    @GetMapping("/export-pdf")
    public void exportPdf(HttpServletResponse response){
        Context context = new Context();
        context.setVariables(new HashMap<>());
        String html = templateEngine.process("index",context);
        //拿到填充好的模板，可以进行任意下游操作
        log.info(html);
//        response.getOutputStream();
    }
}

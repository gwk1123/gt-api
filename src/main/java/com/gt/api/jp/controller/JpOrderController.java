package com.gt.api.jp.controller;

import com.gt.api.jp.service.JpVerifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JpOrderController {

    private Logger logger = LoggerFactory.getLogger(JpOrderController.class);


    @PostMapping("/order")
    public Object order(@RequestBody String str) {
        logger.info("order请求参数:{}",str);
        return null;
    }
}

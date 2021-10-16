package com.gt.api.jp.controller;


import com.alibaba.fastjson.JSON;
import com.gt.api.jp.ota.verify.VerifyRequest;
import com.gt.api.jp.service.JpVerifyService;
import com.gt.api.jp.vo.verify.VerifyRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JpVerifyController {

    @Autowired
    private JpVerifyService jpVerifyService;

    private Logger logger = LoggerFactory.getLogger(JpVerifyController.class);

    @PostMapping("/verify")
    public Object search(@RequestBody String str) {
        logger.info("verify请求参数:{}", str);
        VerifyRequest verifyRequest = transformVerifyRequest(str);
        return jpVerifyService.verify(JSON.toJSONString(verifyRequest));
    }

    public VerifyRequest transformVerifyRequest(String str) {
        VerifyRequestDto verifyRequestDto = JSON.parseObject(str, VerifyRequestDto.class);
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setAdultNumber(1);
        verifyRequest.setTripType("0".equals(verifyRequestDto.getIsRt()) ? "2" : "1");
        verifyRequest.setRouting(verifyRequestDto.getRouting());
        return verifyRequest;
    }

}

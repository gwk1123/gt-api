package com.gt.api.jp.service.impl;

import com.gt.api.jp.service.JpVerifyService;
import com.gt.api.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

@Service
public class JpVerifyServiceImpl implements JpVerifyService {


    String verify_url = "http://localhost:8091/api/ctrip/verify/xcpt";

    @Override
    public Object verify(String str) {
        return HttpRequestUtil.post(verify_url,str);
    }
}

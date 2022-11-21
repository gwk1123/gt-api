package com.gt.api.jp.service.impl;

import com.gt.api.jp.service.JpOrderService;
import com.gt.api.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

@Service
public class JpOrderServiceImpl implements JpOrderService {

    private static String order_url = "http://localhost:8091/api/ctrip/order/xcpt";

    @Override
    public String order(String str) {
        return HttpRequestUtil.post(order_url, str);
    }
}

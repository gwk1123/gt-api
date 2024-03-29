package com.gt.api.jp.service.impl;

import com.gt.api.jp.service.JpSearchService;
import com.gt.api.utils.HttpRequestUtil;
import org.springframework.stereotype.Service;

@Service
public class JpSearchServiceImpl implements JpSearchService {

    String search_url = "http://localhost:8091/api/ctrip/search/xcpt";

    @Override
    public String search(String str) {
        return HttpRequestUtil.post(search_url,str);
    }
}

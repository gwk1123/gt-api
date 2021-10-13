package com.gt.api.jp.controller;

import com.alibaba.fastjson.JSON;
import com.gt.api.jp.service.JpSearchService;
import com.gt.api.jp.vo.search.JpSearchRequest;
import com.gt.api.jp.vo.search.SearchRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JpSearchController {

    private Logger logger = LoggerFactory.getLogger(JpSearchController.class);
    @Autowired
    private JpSearchService jpSearchService;

    @PostMapping("/search")
    public Object search(@RequestBody String str) {
        logger.info("search请求参数:{}",str);
        SearchRequestDto searchRequestDto= transformSearchRequest( str);
        return jpSearchService.search(JSON.toJSONString(searchRequestDto));
    }

    public SearchRequestDto transformSearchRequest(String str){
        JpSearchRequest jpSearchRequest = JSON.parseObject(str,JpSearchRequest.class);
        SearchRequestDto searchRequestDto =new SearchRequestDto();
        searchRequestDto.setAdultNumber(1);
        searchRequestDto.setFromCity(jpSearchRequest.getDep());
        searchRequestDto.setToCity(jpSearchRequest.getArr());
        searchRequestDto.setFromDate(jpSearchRequest.getFromDate());
        searchRequestDto.setTripType("0".equals(jpSearchRequest.getIsRt())?"2":"1");
        if("0".equals(jpSearchRequest.getIsRt())) {
            searchRequestDto.setRetDate(jpSearchRequest.getRetDate());
        }
        return searchRequestDto;
    }

}

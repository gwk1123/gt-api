package com.gt.api.ty.controller;

import com.alibaba.fastjson.JSON;
import com.gt.api.ty.ota.search.SearchResponse;
import com.gt.api.ty.service.TySearchService;
import com.gt.api.ty.vo.search.SearchRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ty")
public class TySearchController {

    @Autowired
    private TySearchService searchService;
    private Logger logger = LoggerFactory.getLogger(TySearchController.class);

    @RequestMapping(value = "/search")
    public SearchResponse serach(@RequestBody String request) {
        logger.info("请求参数:{}", JSON.toJSONString(request));
        SearchRequestDto searchRequestDto = JSON.parseObject(request, SearchRequestDto.class);
        return searchService.search(searchRequestDto);
    }

}

package com.gt.api.ty.service;

import com.gt.api.ota.search.SearchResponse;
import com.gt.api.ty.vo.search.SearchRequestDto;

public interface SearchService {

    public SearchResponse search(SearchRequestDto searchRequestDto);

}

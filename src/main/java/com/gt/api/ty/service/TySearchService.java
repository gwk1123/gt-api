package com.gt.api.ty.service;

import com.gt.api.ty.ota.search.SearchResponse;
import com.gt.api.ty.vo.search.SearchRequestDto;

public interface TySearchService {

    public SearchResponse search(SearchRequestDto searchRequestDto);

}

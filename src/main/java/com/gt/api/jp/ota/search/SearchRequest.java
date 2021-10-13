package com.gt.api.jp.ota.search;

import lombok.Data;

@Data
public class SearchRequest {

    private String uuid;
    private String cid ="6e2b04bf29644892";
    private String tripType;
    private String fromCity;
    private String toCity;
    private String fromDate;
    private String retDate;
    private int adultNumber = 1;
    private int childNumber;
    private int infantNumber;
    private String channel;
    private String isCompressEncode;
}

package com.gt.api.jp.vo.search;

import lombok.Data;

@Data
public class JpSearchRequest {

    private String uid;
    private String dep;
    private String arr;
    private String isRt; //0-往返 1-单程
    private String fromDate;
    private String retDate;
}

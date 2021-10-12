package com.gt.api.ty.vo.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchRequestDto implements Serializable {

    private String DepartStation;
    private String ArriveStation;
    private String DepartDate;
    private String ChannelName;

}

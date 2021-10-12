package com.gt.api.ty.vo.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestItemDto implements Serializable {
    private String TrainName;
    private String DepartStation;
    private String ArrStation;
    private String DepartureDate;
}

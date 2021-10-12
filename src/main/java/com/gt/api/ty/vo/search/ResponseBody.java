package com.gt.api.ty.vo.search;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBody {

    private String ResponseStatus;
    private String DepartureSearchPinYin;
    private String DepartureSearchPinYinV2;
    private String DepartureSearchName;
    private String ArrivalSearchPinYin;
    private String ArrivalSearchPinYinV2;
    private String ArrivalSearchName;
    private String DepartureDate;
    private int BookingSystemType;
    private DepartureCity DepartureCity;
    private ArriveCity ArriveCity;
    private List<TrainItems> TrainItems;
}

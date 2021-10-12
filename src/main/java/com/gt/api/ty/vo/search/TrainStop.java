package com.gt.api.ty.vo.search;

import lombok.Data;

@Data
public class TrainStop {

    private String StationSequence;
    private String StationName;
    private String DepartureTime;
    private String ArrivalTime;
    private String StopTimes;
    private String DistanceFromStart;
}

package com.gt.api.ty.ota.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class StopInfo implements Serializable {

    private String stationSequence; //车站序列
    private String stationName; //站名
    private String departureTime;//出发时间
    private String arrivalTime; //到达时间
    private String stopTimes; // 停止时间
    private String distanceFromStart; //距离起点

}

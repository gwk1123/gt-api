package com.gt.api.ty.ota.search;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Routing implements Serializable {

    private String trainName; //K1347
    private String trainShortName; // 列车短名 K G
    private String departureStationName; //起始站名 深圳
    private String departureStationCode; //起始编号 SZX
    private String arrivalStationName;//终点站 深圳
    private String arrivalStationCode; //终点站编号
    private String departureTime; // 起始时间  2021-10-10 05:30
    private String arrivalTime; //到站时间 2021-10-10 20:23
    private String preSaleTime; //出售时间说明 10月08日 12:30开售
    private List<StopInfo> stopInfos; //经停站集合信息
    private List<PriceInfo> priceInfos; //票价信息

}

package com.gt.api.ty.vo.search;

import lombok.Data;

import java.util.List;

@Data
public class TicketResult {

    private int DepartureStationID;
    private String DepartureStationName;
    private int ArrivalStationID;
    private String ArrivalStationName;
    private String DepartureTime;
    private String ArrivalTime;
    private int Distance;
    private int TakeDays;
    private String TrainShortName;
    private String DepartureStationPinyin;
    private String ArrivalStationPinyin;
    private boolean DepartureIsStart;
    private boolean ArrivalIsEnd;
    private List<TicketItems> TicketItems;
}

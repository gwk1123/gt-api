package com.gt.api.jp.vo.order;

import lombok.Data;

@Data
public class SegmentDto {

    private String carrier;

    private String flightNumber;

    private String depAirport;

    private String depTime;

    private String arrAirport;

    private String arrTerminal;

    private String arrTime;

    private boolean codeShare;

    private String cabin;

    private String cabinGrade;

    private String aircraftCode;

    private int duration;

}

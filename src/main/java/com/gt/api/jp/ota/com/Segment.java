package com.gt.api.jp.ota.com;

import lombok.Data;

@Data
public class Segment {

    private String carrier;
    private String flightNumber;
    private String depAirport;
    private String depTerminal;
    private String depTime;
    private String arrAirport;
    private String arrTerminal;
    private String arrTime;
    private String stopCities;
    private String stopAirports;
    private Boolean codeShare;
    private String operatingCarrier;
    private String operatingFlightNo;
    private String cabin;
    private String cabinGrade;
    private String aircraftCode;
    private Integer duration;
}

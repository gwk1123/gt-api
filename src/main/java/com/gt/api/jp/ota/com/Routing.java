package com.gt.api.jp.ota.com;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Routing {

    private String data;
    private Integer publishPrice;
    private Integer adultPrice;
    private Integer adultTax;
    private Integer childPublishPrice;
    private Integer childPrice;
    private Integer childTax;
    private Integer infantPublishPrice;
    private Integer infantPrice;
    private Integer infantTax;
    private Integer adultTaxType;
    private Integer childTaxType;
    private Integer priceType;
    private Integer applyType;
    private BigDecimal exchange;
    private String adultAgeRestriction;
    private String eligibility;
    private String nationality;
    private String forbiddenNationality;
    private Integer planCategory;
    private String invoiceType;
    private String minStay;
    private String maxStay;
    private Integer minPassengerCount;
    private Integer maxPassengerCount;
    private String bookingOfficeNo;
    private String ticketingOfficeNo;
    private String validatingCarrier;
    private String reservationType;
    private String productType;
    private String fareBasis;
    private List<Segment> fromSegments;
    private List<Segment> retSegments;
    private Rule rule;
    private String poscode = "HK";

}

package com.gt.api.jp.vo.order;

import com.gt.api.jp.ota.com.Rule;
import lombok.Data;

import java.util.List;

@Data
public class RoutingDto {

    private String data;

    private int adultPrice;

    private int adultTax;

    private int childPrice;

    private int childTax;

    private int adultTaxType;

    private int childTaxType;

    private int priceType;

    private int applyType;

    private String eligibility;

    private String invoiceType;

    private int minPassengerCount;

    private String validatingCarrier;

    private String reservationType;

    private String productType;

    private List<SegmentDto> fromSegments ;

    private Rule rule;

    private String poscode;
}

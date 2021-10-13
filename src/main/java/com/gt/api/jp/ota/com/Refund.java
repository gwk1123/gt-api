package com.gt.api.jp.ota.com;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Refund {

    private Integer refundType;
    private String refundStatus;
    private BigDecimal refundFee;
    private String currency;
    private Integer passengerType;
    private String refNoshow;
    private Integer refNoShowCondition;
    private BigDecimal refNoshowFee;
    private String cnRefRemark;
    private String enRefRemark;
}

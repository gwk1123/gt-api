package com.gt.api.jp.ota.com;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Change {

    private Integer changesType;
    private String changesStatus;
    private BigDecimal changesFee;
    private String currency;
    private Integer passengerType;
    private String revNoshow;
    private Integer revNoShowCondition;
    private BigDecimal revNoshowFee;
    private String cnRevRemark;
    private String enRevRemark;
}

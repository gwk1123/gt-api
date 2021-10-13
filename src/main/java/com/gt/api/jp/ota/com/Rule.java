package com.gt.api.jp.ota.com;

import lombok.Data;

import java.util.List;

@Data
public class Rule {

    private List<FormatBaggage> formatBaggageInfoList;
    private List<Refund> refundInfoList;
    private List<Change> changesInfoList;
    private String note;
    private Boolean isUseCtripRule;
    private String tariffNo;
    private String ruleNo;
    private Integer fareRuleMatchMode;
}

package com.gt.api.jp.ota.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RefRevServiceFee {

    //携程订单号
    private long id;

    //退改签推送状态：0 正常， 1 异常
    private int status;

    //去程改期费用
    private BigDecimal outboundRevalidationFee;

    //去程是否可改
    private String outNonChg;

    //回程改期费用
    private BigDecimal inboundRevalidationFee;

    //回程是否可改
    private String inNonChg;

    //合作票台退票服务费
    private BigDecimal refundFeeByConsolidator;

    //全部未使用退票费用
    private BigDecimal outRefundFee;

    //全部未使用可否退票
    private String outNonRef;

    //部分使用退票费用
    private BigDecimal inRefundFee;

    //部分使用可否退票
    private String inNonRef;

    //合作票台改期服务费
    private BigDecimal revalidationFeeByConsolidator;

    //去程改期费用币种
    private String outRevFeeCurrency;

    //回程改期费用币种
    private String inRevFeeCurrency;

    //部分使用退票费用币种
    private String inRefCurrency;

    //全部未使用退票费用币种
    private String outRefCurrency;

    //是否允许去程改期
    private String outNonRev;

    //是否允许回程改期
    private String inNonRev;

    //去程儿童改期费
    private BigDecimal outRevChdFee;

    //回程儿童改期费
    private BigDecimal inRevChdFee;

    //是否允许No Show改期
    private String revHasNoShow;

    //去程No Show改期费用（成人）
    private BigDecimal outRevNoShowFee;

    //回程No Show改期费用（成人）
    private BigDecimal inRevNoShowFee;

    //去程 No Show改期儿童费用
    private BigDecimal outRevNoShowChdFee;

    //回程 No Show改期儿童费用
    private BigDecimal inRevNoShowChdFee;

    //NoShow改期条件
    private BigDecimal revNoShowCondition;

    //全部退票儿童费用-去程
    private BigDecimal outRefChdFee;

    //部分退票儿童费用
    private BigDecimal inRefChdFee;

    //是否允许No Show退票
    private String refHasNoShow;

    //全部No Show退票费用（成人）-去程
    private BigDecimal outRefNoShowFee;

    //部分No Show退票费用（成人）
    private BigDecimal inRefNoShowFee;

    //全部No Show退票儿童费用-去程
    private BigDecimal outRefNoShowChdFee;

    //部分No Show退票儿童费用
    private BigDecimal inRefNoShowChdFee;

    //No-Show退票条件
    private BigDecimal refNoShowCondition;
}

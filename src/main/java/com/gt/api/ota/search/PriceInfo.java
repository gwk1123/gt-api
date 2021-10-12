package com.gt.api.ota.search;

import lombok.Data;

import java.io.Serializable;

/**
 * 票价信息
 */

@Data
public class PriceInfo implements Serializable {

    private String dataKey;
    private String ticketId;//票号
    private boolean bookable; //可预订
    private String seatTypeId; //座位类型ID;
    private String seatTypeName; // 座位类型名称 硬座
    private String price; //票价
    private String  showPrice; //显示价格
    private String inventory;// 存货

}

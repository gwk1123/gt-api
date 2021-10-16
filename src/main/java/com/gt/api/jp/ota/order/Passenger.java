package com.gt.api.jp.ota.order;

import lombok.Data;

@Data
public class Passenger {

    //LastName/FirstName MiddleName，姓/名
    private String name;

    //乘客类型，0 成人/1 儿童/2 婴儿
    private int ageType;

    //生日，格式：YYYYMMDD
    private String birthday;

    //乘客性别，M 男 / F 女
    private String gender;

    //证件号码,最大 15 个字符
    private String cardNum;

    /*
     * 证件类型：
     * PP - 护照
     * GA - 港澳通行证
     * TW - 台湾通行证
     * TB - 台胞证
     * HX - 回乡证
     * HY - 国际海员证
     */
    private String cardType;

    //证件发行国家，国家二字码
    private String cardIssuePlace;

    //证件有效时间，格式：YYYYMMDD
    private String cardExpired;

    //乘客国籍，国家二字码
    private String nationality;
    private String phone;


}

package com.gt.api.jp.ota.order;

import lombok.Data;

@Data
public class Contact {

    //联系人姓名，不单独区分姓和名
    private String name;

    //详细地址
    private String address;

    //邮编
    private String postcode;

    //联系人邮箱
    private String email;

    //联系人手机号
    private String mobile;
}

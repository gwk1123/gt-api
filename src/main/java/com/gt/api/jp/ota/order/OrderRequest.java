package com.gt.api.jp.ota.order;

import com.gt.api.jp.ota.com.Routing;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    //接口身份标识用户名（渠道唯一标识) 相当于APP KEY
    private String cid;

    //行程类型，1：单程；2：往返；3：多程；
    private String tripType;

    //会话标识：标记服务接口调用的唯一标识，会将价格校验接口中的 sessionId 原值传给供应商
    private String sessionId;

    //报价信息，参考搜索返回结果中的 Routing Elements。
    // 1）只含航班信息,航班信息不含经停城市/机场，机型；
    // 2）不含价格信息、退改签信息、行李额信息等。
    private Routing routing;

    //乘机人信息
    private List<Passenger> passengers;

    //联系人信息
    private Contact contact;

    //乘机人预订行李信息
//    private CtripPassengerBaggage passengerbaggages;

    //携程退改费用信息
    private List<RefRevServiceFee> ctripRefRevServiceFee;

    //携程关联ID；携程用来查问题用的。
    private String referenceId;

}

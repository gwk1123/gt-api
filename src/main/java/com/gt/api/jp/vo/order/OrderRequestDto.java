package com.gt.api.jp.vo.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    private RoutingDto routing;
    private List<PassengerDto> passengers ;
    private ContactDto contact;
}

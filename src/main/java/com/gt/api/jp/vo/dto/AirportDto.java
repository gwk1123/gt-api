package com.gt.api.jp.vo.dto;

import lombok.Data;

import java.util.List;

@Data
public class AirportDto {

    private String name;
    private String code;
    private String timezone;
    private String cname;
    private String desc;
    private List<Al> al;

    @Data
    public static class Al{

        private String n;
        private String c;
    }


}

package com.gt.api.ty.vo.search;

import lombok.Data;

import java.util.List;

@Data
public class ResponseStatus {

    private String Timestamp;
    private String Ack;
    private List<String> Errors;
    private String Build;
    private String Version;
    private List<Extension> Extension;
}

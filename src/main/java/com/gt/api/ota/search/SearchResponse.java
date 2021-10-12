package com.gt.api.ota.search;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchResponse implements Serializable {

    private Integer status;

    private String uid;

    private String msg;

    private List<Routing> routings;

}

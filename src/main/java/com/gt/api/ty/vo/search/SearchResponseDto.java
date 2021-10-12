package com.gt.api.ty.vo.search;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchResponseDto implements Serializable {

    private ResponseStatus ResponseStatus;
    private ResponseBody ResponseBody;
}

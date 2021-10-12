package com.gt.api.ty.vo.search;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseItemDto implements Serializable {


    private ResponseStatus ResponseStatus;
    private List<TrainStop> TrainStopList;
}

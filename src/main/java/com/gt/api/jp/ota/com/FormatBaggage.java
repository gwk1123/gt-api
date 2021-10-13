package com.gt.api.jp.ota.com;

import lombok.Data;

@Data
public class FormatBaggage {

    private Integer segmentNo;
    private Integer passengerType;
    private Integer baggagePiece;
    private Integer baggageWeight;
    private String cnBaggage;
    private String enBaggage;
}

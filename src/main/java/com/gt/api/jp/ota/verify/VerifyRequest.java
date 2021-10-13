package com.gt.api.jp.ota.verify;

import com.gt.api.jp.ota.com.Routing;
import lombok.Data;

@Data
public class VerifyRequest {
    private String cid = "6e2b04bf29644892";
    private String referenceId;
    private String tripType;
    private String requestType;
    private int adultNumber = 1;
    private int childNumber;
    private int infantNumber;
    private Routing routing;
}

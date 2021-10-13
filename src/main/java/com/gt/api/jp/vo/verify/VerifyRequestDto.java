package com.gt.api.jp.vo.verify;

import com.gt.api.jp.ota.com.Routing;
import lombok.Data;

@Data
public class VerifyRequestDto {

    private String isRt; //0-往返 1-单程
    private Routing routing;
}

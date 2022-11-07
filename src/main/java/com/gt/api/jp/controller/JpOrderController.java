package com.gt.api.jp.controller;

import com.alibaba.fastjson.JSON;
import com.gt.api.jp.ota.com.Routing;
import com.gt.api.jp.ota.order.Contact;
import com.gt.api.jp.ota.order.OrderRequest;
import com.gt.api.jp.ota.order.Passenger;
import com.gt.api.jp.service.JpOrderService;
import com.gt.api.jp.vo.order.OrderRequestDto;
import com.gt.api.utils.AESOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class JpOrderController {

    @Autowired
    private JpOrderService jpOrderService;

    private static String skey = "8784337598743272";
    private static String cid = "6e2b04bf29644892";
    private static String ssionId = "11112222333";

    private Logger logger = LoggerFactory.getLogger(JpOrderController.class);

    @PostMapping("/order")
    public Object order(@RequestBody String str) throws Exception {
        logger.info("order请求参数:{}", str);
        String questStr = transformOrderRequest(str);
        String responseSrt = jpOrderService.order(questStr);
        logger.info("order返回报文:{}", responseSrt);
        return null;
    }

    public String transformOrderRequest(String str) throws Exception {
        OrderRequestDto orderResponseDto = JSON.parseObject(str, OrderRequestDto.class);
        Routing  routing = JSON.parseObject(JSON.toJSONString(orderResponseDto.getRouting()),Routing.class);
        List<Passenger> passengerList = orderResponseDto.getPassengers().stream().filter(Objects::nonNull).map(passengerDto -> {
            Passenger passenger =new Passenger();
            String birthday = StringUtils.isEmpty(passengerDto.getBirth())?"19921010":passengerDto.getBirth().replaceAll("-","");
            passenger.setBirthday(birthday);
            passenger.setCardNum(passengerDto.getIdNo());
            passenger.setGender(passengerDto.getGender());
            passenger.setName(passengerDto.getName());
            passenger.setPhone(passengerDto.getPhone());
            passenger.setCardType("PP");
            return passenger;
        }).collect(Collectors.toList());

        Contact contact =new Contact();
        contact.setName(orderResponseDto.getContact().getName());
        contact.setAddress(orderResponseDto.getContact().getAddress());
        contact.setEmail(orderResponseDto.getContact().getEmail());
        contact.setMobile(orderResponseDto.getContact().getMobile());
        contact.setPostcode(orderResponseDto.getContact().getPostcode());
        OrderRequest orderRequest =new OrderRequest();
        orderRequest.setCid(cid);
        orderRequest.setSessionId(ssionId);
        orderRequest.setTripType("1");

        orderRequest.setReferenceId("424124");

        orderRequest.setContact(contact);
        orderRequest.setRouting(routing);
        orderRequest.setPassengers(passengerList);
        String encrypt = JSON.toJSONString(orderRequest);
        String encryptResult = AESOperator.getInstance().jdk8encrypt(encrypt,skey);
        return encryptResult;
    }

    //解密
    public String transformOrderSeponse(String str){
        return null;
    }
}

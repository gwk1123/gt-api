package com.gt.api.ty.service.impl;

import com.alibaba.fastjson.JSON;
import com.gt.api.ty.ota.search.PriceInfo;
import com.gt.api.ty.ota.search.Routing;
import com.gt.api.ty.ota.search.SearchResponse;
import com.gt.api.ty.ota.search.StopInfo;
import com.gt.api.ty.service.SearchService;
import com.gt.api.ty.vo.search.*;
import com.gt.api.utils.HttpRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class SearchServiceImpl implements SearchService {

    @Qualifier("ytPoolExecutor")
    @Autowired
    private ThreadPoolTaskExecutor ytPoolExecutor;
    private static String SEARCH_URL = "https://m.ctrip.com/restapi/soa2/14666/json/GetBookingByStationV3ForPC";
    private static String SEARC_ITEM_URL = "https://m.ctrip.com/restapi/soa2/14666/json/GetTrainStopListV3";
    private Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Override
    public SearchResponse search(SearchRequestDto searchRequestDto) {

        String requestStr = JSON.toJSONString(searchRequestDto);
        String data = HttpRequestUtil.post(SEARCH_URL,requestStr);
        logger.info("返回的数据:{}",data);
        if(StringUtils.isEmpty(data)){
            return null;
        }
        return this.transformSrarchRequest( data, searchRequestDto);
    }

    public SearchResponse transformSrarchRequest(String data,SearchRequestDto searchRequestDto){
        SearchResponse searchResponse =new SearchResponse();
        searchResponse.setStatus(0);
        SearchResponseDto searchResponseDto = JSON.parseObject(data,SearchResponseDto.class);
        if(CollectionUtils.isEmpty(searchResponseDto.getResponseBody().getTrainItems())){
            searchResponse.setRoutings(new ArrayList<>());
            return searchResponse;
        }
        List<Routing> routings = searchResponseDto.getResponseBody().getTrainItems().parallelStream().map(item ->{
            return transformRouting( item, searchRequestDto);
        }).collect(Collectors.toList());

//        List<Routing> routings = searchResponseDto.getResponseBody().getTrainItems().parallelStream()
//                .map(item -> CompletableFuture.supplyAsync(() -> this.transformRouting( item, searchRequestDto), ytPoolExecutor))
//                .map(CompletableFuture::join).collect(Collectors.toList());

        searchResponse.setRoutings(routings);
        return searchResponse;
    }


    public Routing transformRouting(TrainItems item,SearchRequestDto searchRequestDto){
        Routing routing =new Routing();
        routing.setTrainName(item.getTrainName());
        routing.setTrainShortName(item.getTrainShortName());
        routing.setDepartureStationName(item.getTicketResult().getDepartureStationName());
        routing.setArrivalStationName(item.getTicketResult().getArrivalStationName());
        routing.setDepartureTime(item.getTicketResult().getDepartureTime());
        routing.setArrivalTime(item.getTicketResult().getArrivalTime());
        routing.setPreSaleTime(item.getPreSaleTime());

        List<PriceInfo> priceInfos = item.getTicketResult().getTicketItems().stream().map(ticket ->{
            PriceInfo priceInfo = new PriceInfo();
            priceInfo.setTicketId(ticket.getTicketID());
            priceInfo.setBookable(ticket.isBookable());
            priceInfo.setSeatTypeId(ticket.getSeatTypeID());
            priceInfo.setSeatTypeName(ticket.getSeatTypeName());
            priceInfo.setPrice(ticket.getPrice());
            priceInfo.setShowPrice(ticket.getShowPrice());
            priceInfo.setInventory(ticket.getInventory());
            return priceInfo;
        }).collect(Collectors.toList());
        routing.setPriceInfos(priceInfos);

        List<StopInfo>  stopInfos= this.transformStopInfo(this.transformRequestStop(routing.getTrainName(), searchRequestDto));
        routing.setStopInfos(stopInfos);
        return routing;
    }





    public RequestItemDto transformRequestStop(String trainName,SearchRequestDto searchRequestDto){
        RequestItemDto requestItemDto =new RequestItemDto();
        requestItemDto.setTrainName(trainName);
        requestItemDto.setDepartStation(searchRequestDto.getDepartStation());
        requestItemDto.setArrStation(searchRequestDto.getArriveStation());
        requestItemDto.setDepartureDate(searchRequestDto.getDepartDate());
        return requestItemDto;
    }


    /**
     * 获取经停站信息
     */
    public List<StopInfo> transformStopInfo(RequestItemDto requestItemDto){

        String requestStr = JSON.toJSONString(requestItemDto);
        String data = HttpRequestUtil.post(SEARC_ITEM_URL,requestStr);
        if(StringUtils.isEmpty(data)){
            return new ArrayList<>();
        }
        ResponseItemDto responseItemDto = JSON.parseObject(data,ResponseItemDto.class);
        if(CollectionUtils.isEmpty(responseItemDto.getTrainStopList())){
            return new ArrayList<>();
        }
        return  responseItemDto.getTrainStopList().parallelStream().map(trainStop -> {
            StopInfo stopInfo =new StopInfo();
            stopInfo.setStationSequence(trainStop.getStationSequence());
            stopInfo.setStationName(trainStop.getStationName());
            stopInfo.setDepartureTime(trainStop.getDepartureTime());
            stopInfo.setArrivalTime(trainStop.getArrivalTime());
            stopInfo.setStopTimes(trainStop.getStopTimes());
            stopInfo.setDistanceFromStart(trainStop.getDistanceFromStart());
            return stopInfo;
        }).collect(Collectors.toList());
    }



}

//package com.gt.api.jp.controller;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.gt.api.jp.entity.AllAirports;
//import com.gt.api.jp.service.AllAirportsService;
//import com.gt.api.jp.service.JpSearchService;
//import com.gt.api.jp.vo.dto.AirportDto;
//import com.gt.api.utils.CommonResult;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * <p>
// * 所有机场表 前端控制器
// * </p>
// *
// * @author liuyc
// * @since 2020-08-16
// */
//
//@RestController
//@RequestMapping("/api")
//public class AllAirportsController {
//
//    private final AllAirportsService allAirportsService;
//
//    public AllAirportsController(AllAirportsService allAirportsService) {
//        this.allAirportsService = allAirportsService;
//    }
//
//
//    @GetMapping("/all_airports/page")
//    public CommonResult pageAllAirports(Page<AllAirports> page, AllAirports allAirports) {
//        IPage<AllAirports> iPage= allAirportsService.pageAllAirports(page, allAirports);
//        return CommonResult.success(iPage);
//    }
//
//    @GetMapping("/all_airports/{id}")
//    public CommonResult getAllAirportsById(@PathVariable String id) {
//        return CommonResult.success(allAirportsService.getAllAirportsById(id));
//    }
//
//    @PostMapping("/keyword")
//    public CommonResult getAllAirportsByKeyword(@RequestBody String keyword) {
//
//        List<AllAirports> allAirports = allAirportsService.getAllAirportsByKeyword(keyword);
//        List<AirportDto> airportDtos =new ArrayList<>();
//        if(!CollectionUtils.isEmpty(allAirports)){
//            Map<String,List<AllAirports>> airportMap = allAirports.stream().collect(Collectors.groupingBy(AllAirports::getCcode));
//            airportMap.entrySet().stream().forEach(entry ->{
//                AirportDto airportDto =new AirportDto();
//                List<AirportDto.Al> als = entry.getValue().stream().map(airport ->{
//                    AirportDto.Al al =new AirportDto.Al();
//                    al.setC(airport.getCode());
//                    al.setN(airport.getAirport());
//                    return al;
//                }).collect(Collectors.toList());
//                airportDto.setCode(allAirports.get(0).getCcode());
//                airportDto.setName(allAirports.get(0).getCity());
//                airportDto.setCname(allAirports.get(0).getCountry());
//                airportDto.setAl(als);
//                airportDtos.add(airportDto);
//            });
//        }
//        return CommonResult.success(airportDtos);
//    }
//
//}

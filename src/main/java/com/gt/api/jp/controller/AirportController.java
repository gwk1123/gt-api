package com.gt.api.jp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gt.api.jp.entity.Airport;
import com.gt.api.jp.entity.AllAirports;
import com.gt.api.jp.service.AirportService;
import com.gt.api.jp.vo.dto.AirportDto;
import com.gt.api.utils.CommonResult;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 所有机场表 前端控制器
 * </p>
 *
 * @author liuyc
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/api")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all_airports/page")
    public CommonResult pageAllAirports(Page<Airport> page, Airport airport) {
        IPage<Airport> iPage = airportService.pageAllAirports(page, airport);
        return CommonResult.success(iPage);
    }

    @GetMapping("/all_airports/{id}")
    public CommonResult getAllAirportsById(@PathVariable String id) {
        return CommonResult.success(airportService.getAllAirportsById(id));
    }

    @PostMapping("/keyword")
    public CommonResult getAllAirportsByKeyword(@RequestBody String keyword) {

        List<Airport> allAirports = airportService.getAllAirportsByKeyword(keyword);
        List<AirportDto> airportDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(allAirports)) {
            Map<String, List<Airport>> airportMap = allAirports.stream().collect(Collectors.groupingBy(Airport::getCityCode));
            airportMap.entrySet().stream().forEach(entry -> {
                AirportDto airportDto = new AirportDto();
                List<AirportDto.Al> als = entry.getValue().stream().map(airport -> {
                    AirportDto.Al al = new AirportDto.Al();
                    al.setC(airport.getAirportCode());
                    al.setN(airport.getAirportName());
                    return al;
                }).collect(Collectors.toList());
                airportDto.setCode(allAirports.get(0).getCityCode());
                airportDto.setName(allAirports.get(0).getCityName());
                airportDto.setCname(allAirports.get(0).getCountryName());
                airportDto.setAl(als);
                airportDtos.add(airportDto);
            });
        }
        return CommonResult.success(airportDtos);
    }

}

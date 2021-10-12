package com.gt.api.jp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gt.api.jp.entity.AllAirports;
import com.gt.api.jp.service.AllAirportsService;
import com.gt.api.utils.CommonResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 所有机场表 前端控制器
 * </p>
 *
 * @author liuyc
 * @since 2020-08-16
 */

@RestController
@RequestMapping("/jp")
public class AllAirportsController {

    private final AllAirportsService allAirportsService;

    public AllAirportsController(AllAirportsService allAirportsService) {
        this.allAirportsService = allAirportsService;
    }


    @GetMapping("/all_airports/page")
    public CommonResult pageAllAirports(Page<AllAirports> page, AllAirports allAirports) {
        IPage<AllAirports> iPage= allAirportsService.pageAllAirports(page, allAirports);
        return CommonResult.success(iPage);
    }

    @GetMapping("/all_airports/{id}")
    public CommonResult getAllAirportsById(@PathVariable String id) {
        return CommonResult.success(allAirportsService.getAllAirportsById(id));
    }

    @GetMapping("/all_airports/{id}")
    public CommonResult getAllAirportsByKeyword(@RequestBody String Keyword) {
        return CommonResult.success(allAirportsService.getAllAirportsByKeyword(Keyword));
    }

}

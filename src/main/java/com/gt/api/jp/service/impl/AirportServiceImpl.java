package com.gt.api.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.api.jp.entity.Airport;
import com.gt.api.jp.mapper.AirportMapper;
import com.gt.api.jp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


/**
 * <p>
 * 所有机场表 服务实现类
 * </p>
 *
 * @author liuyc
 * @since 2020-08-16
 */
@Service
public class AirportServiceImpl extends ServiceImpl<AirportMapper, Airport> implements AirportService {

    @Autowired
    private AirportService airportService;

    @Override
    public IPage<Airport> pageAllAirports(Page<Airport> page, Airport allAirports) {
        page = Optional.ofNullable(page).orElse(new Page<>());
        QueryWrapper<Airport> queryWrapper = this.buildQueryWrapper(allAirports);
        return this.page(page, queryWrapper);
    }


    @Override
    public Airport getAllAirportsById(String id) {
        return this.getById(id);
    }

    @Override
    public List<Airport> getAllAirportsByKeyword(String keyword){
        QueryWrapper<Airport> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(!org.springframework.util.StringUtils.isEmpty(keyword), Airport::getCityName, keyword)
                .or().like(!org.springframework.util.StringUtils.isEmpty(keyword), Airport::getAirportCode, keyword)
                .or().like(!org.springframework.util.StringUtils.isEmpty(keyword), Airport::getAirportName, keyword)
                .or().like(!org.springframework.util.StringUtils.isEmpty(keyword), Airport::getCityCode, keyword);
        return this.list(queryWrapper);
    }


    public QueryWrapper<Airport> buildQueryWrapper(Airport allAirports) {
        QueryWrapper<Airport> gdsQueryWrapper = new QueryWrapper<>();
        if (allAirports != null) {
            gdsQueryWrapper.lambda().like(!org.springframework.util.StringUtils.isEmpty(allAirports.getCityName()), Airport::getCityName, allAirports.getCityName())
                    .eq(!org.springframework.util.StringUtils.isEmpty(allAirports.getCityCode()), Airport::getCityCode, allAirports.getCityCode())
                    .like(!org.springframework.util.StringUtils.isEmpty(allAirports.getAirportName()), Airport::getAirportName, allAirports.getAirportName())
                    .eq(!org.springframework.util.StringUtils.isEmpty(allAirports.getAirportCode()), Airport::getAirportCode, allAirports.getAirportCode())
                    .like(!org.springframework.util.StringUtils.isEmpty(allAirports.getCountryName()), Airport::getCountryName, allAirports.getCountryName())
                    .eq(!StringUtils.isEmpty(allAirports.getCountryCode()), Airport::getCountryCode, allAirports.getCountryCode());
        }
        gdsQueryWrapper.lambda().orderByAsc(Airport::getCreateTime);
        return gdsQueryWrapper;
    }
}

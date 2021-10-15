package com.gt.api.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gt.api.jp.entity.AllAirports;
import com.gt.api.jp.mapper.AllAirportsMapper;
import com.gt.api.jp.service.AllAirportsService;
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
public class AllAirportsServiceImpl extends ServiceImpl<AllAirportsMapper, AllAirports> implements AllAirportsService {


    @Override
    public IPage<AllAirports> pageAllAirports(Page<AllAirports> page, AllAirports allAirports) {
        page = Optional.ofNullable(page).orElse(new Page<>());
        QueryWrapper<AllAirports> queryWrapper = this.buildQueryWrapper(allAirports);
        return this.page(page, queryWrapper);
    }


    @Override
    public AllAirports getAllAirportsById(String id) {
        return this.getById(id);
    }

    @Override
    public List<AllAirports> getAllAirportsByKeyword(String keyword){
        QueryWrapper<AllAirports> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(!StringUtils.isEmpty(keyword), AllAirports::getCity, keyword)
        .or().like(!StringUtils.isEmpty(keyword), AllAirports::getCode, keyword)
        .or().like(!StringUtils.isEmpty(keyword), AllAirports::getAirport, keyword)
        .or().like(!StringUtils.isEmpty(keyword), AllAirports::getCcode, keyword);
        return this.list(queryWrapper);
    }


    public QueryWrapper<AllAirports> buildQueryWrapper(AllAirports allAirports) {
        QueryWrapper<AllAirports> gdsQueryWrapper = new QueryWrapper<>();
        if (allAirports != null) {
            gdsQueryWrapper.lambda().like(!StringUtils.isEmpty(allAirports.getCity()), AllAirports::getCity, allAirports.getCity())
                    .eq(!StringUtils.isEmpty(allAirports.getCcode()), AllAirports::getCcode, allAirports.getCcode())
                    .like(!StringUtils.isEmpty(allAirports.getAirport()), AllAirports::getAirport, allAirports.getAirport())
                    .eq(!StringUtils.isEmpty(allAirports.getCode()), AllAirports::getCode, allAirports.getCode())
                    .like(!StringUtils.isEmpty(allAirports.getCountry()), AllAirports::getCountry, allAirports.getCountry())
                    .eq(!StringUtils.isEmpty(allAirports.getGcode()), AllAirports::getGcode, allAirports.getGcode());
        }
        gdsQueryWrapper.lambda().orderByAsc(AllAirports::getCreateTime);
        return gdsQueryWrapper;
    }

}

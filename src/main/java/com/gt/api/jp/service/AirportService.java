package com.gt.api.jp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.api.jp.entity.Airport;

import java.util.List;

/**
 * <p>
 * 所有机场表 服务类
 * </p>
 *
 * @author liuyc
 * @since 2020-08-16
 */
public interface AirportService extends IService<Airport> {

    /**
     * 查询所有机场表分页数据
     *
     * @param page      分页参数
     * @param airport 查询条件
     * @return IPage<AllAirports>
     */
    IPage<Airport> pageAllAirports(Page<Airport> page, Airport airport);


    /**
     * id查询数据
     *
     * @param id id
     * @return AllAirports
     */
    Airport getAllAirportsById(String id);

    List<Airport> getAllAirportsByKeyword( String Keyword);
}

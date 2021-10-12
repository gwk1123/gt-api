package com.gt.api.jp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gt.api.jp.entity.AllAirports;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 所有机场表 服务类
 * </p>
 *
 * @author liuyc
 * @since 2020-08-16
 */
public interface AllAirportsService extends IService<AllAirports> {

    /**
     * 查询所有机场表分页数据
     *
     * @param page      分页参数
     * @param allAirports 查询条件
     * @return IPage<AllAirports>
     */
     IPage<AllAirports> pageAllAirports(Page<AllAirports> page, AllAirports allAirports);


    /**
     * id查询数据
     *
     * @param id id
     * @return AllAirports
     */
    AllAirports getAllAirportsById(String id);

    List<AllAirports> getAllAirportsByKeyword( String Keyword);
}

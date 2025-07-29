package com.yuko.stock.mapper;

import com.yuko.stock.domain.StockVO;

import java.util.List;

public interface StockMapper {
    List<StockVO> getList();

    StockVO get(Long no);
}

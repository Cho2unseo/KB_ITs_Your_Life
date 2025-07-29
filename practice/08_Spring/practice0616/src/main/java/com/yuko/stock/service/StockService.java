package com.yuko.stock.service;

import com.yuko.stock.domain.StockVO;
import com.yuko.stock.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<StockDTO> getList();

    StockVO get(Long no);
}

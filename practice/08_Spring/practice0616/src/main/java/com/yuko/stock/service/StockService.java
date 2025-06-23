package com.yuko.stock.service;

import com.yuko.stock.dto.StockDTO;

import java.util.List;

public interface StockService {
    List<StockDTO> getList();
}

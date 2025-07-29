package com.yuko.stock.service;

import com.yuko.stock.dto.BuyDTO;

import java.util.List;

public interface BuyService {
    void buy(BuyDTO dto);

    List<BuyDTO> getList();

    void sell(Long id);
}

package com.yuko.stock.mapper;

import com.yuko.stock.domain.BuyVO;

import java.util.List;

public interface BuyMapper {
    void insert(BuyVO vo);

    List<BuyVO> getList();

    void delete(Long id);
}

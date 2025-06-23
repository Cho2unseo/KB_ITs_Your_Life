package com.yuko.stock.service;

import com.yuko.stock.dto.StockDTO;
import com.yuko.stock.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {
    final private StockMapper mapper;

    @Override
    public List<StockDTO> getList() {
        return mapper.getList().stream()
                .map(StockDTO::of)
                .toList();
    }
}

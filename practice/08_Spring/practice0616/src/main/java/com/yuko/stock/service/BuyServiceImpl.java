package com.yuko.stock.service;

import com.yuko.stock.domain.BuyVO;
import com.yuko.stock.dto.BuyDTO;
import com.yuko.stock.mapper.BuyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuyServiceImpl implements BuyService {
    final private BuyMapper mapper;

    @Override
    public void buy(BuyDTO dto) {
        BuyVO vo = new BuyVO();
        vo.setStockCode(dto.getStockCode());
        vo.setStockName(dto.getStockName());
        vo.setPrice(dto.getPrice());

        mapper.insert(vo);
    }

    @Override
    public List<BuyDTO> getList() {
        List<BuyVO> voList = mapper.getList();
        return voList.stream().map(vo -> {
            BuyDTO dto = new BuyDTO();
            dto.setId(vo.getId());
            dto.setStockCode(vo.getStockCode());
            dto.setStockName(vo.getStockName());
            dto.setPrice(vo.getPrice());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            dto.setBuyDate(sdf.format(vo.getBuyDate()));
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void sell(Long id) {
        mapper.delete(id);
    }
}

package com.yuko.icecream.service;

import com.yuko.icecream.domain.IcecreamVO;
import com.yuko.icecream.dto.IcecreamDTO;
import com.yuko.icecream.mapper.IcecreamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class IcecreamServiceImpl implements IcecreamService{

    final private IcecreamMapper mapper;

    @Override
    public void create(IcecreamDTO icecream) {
        IcecreamVO vo = icecream.toVo();
        mapper.create(vo);
        icecream.setNo(vo.getNo());
        log.info("create... " + icecream);
    }

    @Override
    public List<IcecreamDTO> findAll() {
        return mapper.findAll().stream()
                .map(IcecreamDTO::of)
                .toList();
    }

    @Override
    public boolean delete(Long no) {
        return mapper.delete(no) == 1;
    }
}

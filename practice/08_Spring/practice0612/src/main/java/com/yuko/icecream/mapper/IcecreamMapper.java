package com.yuko.icecream.mapper;

import com.yuko.icecream.domain.IcecreamVO;
import com.yuko.icecream.dto.IcecreamDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IcecreamMapper {

    public List<IcecreamVO> getList();

    public IcecreamVO get(Long no);

    public void create(IcecreamVO icecream);
}

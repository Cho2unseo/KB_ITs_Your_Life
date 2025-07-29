package com.yuko.icecream.service;

import com.yuko.icecream.dto.IcecreamDTO;

import java.util.List;

public interface IcecreamService {
    public void create(IcecreamDTO icecream);

    public List<IcecreamDTO> findAll();

    public boolean delete(Long no);
}

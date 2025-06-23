package com.yuko.icecream.mapper;

import com.yuko.config.RootConfig;
import com.yuko.icecream.domain.IcecreamVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j2
class IcecreamMapperTest {

    @Autowired
    private IcecreamMapper mapper;

    @Test
    @DisplayName("IcecreamMapper의 목록 불러오기")
    public void getList() {
        for (IcecreamVO icecream: mapper.getList()) {
            log.info(icecream);
        }
    }

    @Test
    @DisplayName("IcecreamMapper의 게시글 읽기")
    public void get() {
        IcecreamVO icecream = mapper.get(1L);

        log.info(icecream);
    }
}
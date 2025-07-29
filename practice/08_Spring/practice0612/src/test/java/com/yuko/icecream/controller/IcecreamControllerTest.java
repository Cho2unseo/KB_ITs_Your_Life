package com.yuko.icecream.controller;

import com.yuko.config.RootConfig;
import com.yuko.config.ServletConfig;
import com.yuko.icecream.dto.IcecreamDTO;
import com.yuko.icecream.service.IcecreamService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class
})
@Log4j2

class IcecreamControllerTest {

    @Autowired
    IcecreamService service;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void create() throws Exception {
        String viewName = mockMvc.perform(
                MockMvcRequestBuilders.post("/icecream/new")
                        .param("name", "유니콘젤리")
                        .param("flavor", "알록달록 젤리가 씹히는 무지개 맛")
                        .param("price", "3900"))
                .andReturn()
                .getModelAndView()
                .getViewName();
        log.info("이동되는 뷰:" + viewName);
    }

    @Test
    void list() throws Exception {
        ModelAndView mav = mockMvc.perform(MockMvcRequestBuilders.get("/icecream/list"))
                .andReturn()
                .getModelAndView();
        log.info("뷰 이름: {}", mav.getViewName());
        List<?> list = (List<?>) mav.getModel().get("list");
        log.info("조회된 아이스크림 수: {}", list.size());
        for (Object a: list) {
            log.info(" - {}", a);
        }
        log.info(mav);
    }

    @Test
    void delete() throws Exception {
        ModelAndView mav = mockMvc.perform(
                MockMvcRequestBuilders.post("/icecream/delete")
                        .param("no", "2"))
                .andReturn()
                .getModelAndView();
        log.info("✅ 이동된 뷰 이름: {}", mav.getViewName());
        log.info("Model의 result 값: {}", mav.getModel().get("result"));
    }
}
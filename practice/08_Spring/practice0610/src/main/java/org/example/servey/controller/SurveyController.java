package org.example.servey.controller;

import lombok.extern.log4j.Log4j2;
import org.example.servey.dto.SurveyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링이 컨트롤러로 인식하고 bean 등록
@Log4j2 // Lombok 로그 설정
public class SurveyController {

    @GetMapping("/")
    public String home() {
        return "redirect:/survey";
    }

    @GetMapping("/survey")
    public String form() {
        log.info("into survey......");
        return "/survey/form";
    }
}

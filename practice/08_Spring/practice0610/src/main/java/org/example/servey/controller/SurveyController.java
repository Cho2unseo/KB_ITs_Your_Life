package org.example.servey.controller;

import lombok.extern.log4j.Log4j2;
import org.example.servey.dto.SurveyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller // 스프링이 컨트롤러로 인식하고 bean 등록
@Log4j2 // Lombok 로그 설정
public class SurveyController {

    private Long idx = 1L;

    Map<Long, SurveyDTO> map = new HashMap<>();

    @GetMapping("/")
    public String home() {
        return "redirect:/survey";
    }

    @GetMapping("/survey")
    public String form() {
        log.info("into survey......");
        return "/survey/form";
    }

    @PostMapping("/survey")
    public String form(@ModelAttribute SurveyDTO dto) {
        map.put(idx, dto);
        return "redirect:/survey/share?id=" + (idx++);
    }

    @GetMapping("/survey/share")
    public String getData(@RequestParam("id") Long id, Model model) {
        SurveyDTO dto = map.get(id);
        if (dto == null) return "error/404";
        model.addAttribute("survey", dto);
        return "/survey/share";
    }
}

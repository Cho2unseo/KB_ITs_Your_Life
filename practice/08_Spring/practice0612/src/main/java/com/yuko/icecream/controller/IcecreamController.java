package com.yuko.icecream.controller;


import com.yuko.icecream.dto.IcecreamDTO;
import com.yuko.icecream.service.IcecreamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/icecream")
@RequiredArgsConstructor
public class IcecreamController {

    final private IcecreamService service;

    @PostMapping("/new")
    public String create(IcecreamDTO icecream) {
        log.info("create: " + icecream);
        service.create(icecream);
        return "redirect:/icecream/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", service.findAll());
        return "icecream/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no, Model model) {
        model.addAttribute("result", service.delete(no));
        return "icecream/delete_result";
    }
}

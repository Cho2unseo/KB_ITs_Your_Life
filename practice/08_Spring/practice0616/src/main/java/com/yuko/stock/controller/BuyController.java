package com.yuko.stock.controller;

import com.yuko.stock.dto.BuyDTO;
import com.yuko.stock.service.BuyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/stock")
@RequiredArgsConstructor

public class BuyController {
    final private BuyService service;

    @PostMapping("/buy")
    public String buy(@ModelAttribute BuyDTO dto) {
        service.buy(dto);
        return "redirect:/stock/list";
    }

    @GetMapping("/buyList")
    public String buyList(Model model) {
        model.addAttribute("list", service.getList());
        return "stock/buyList";
    }

    @PostMapping("/sell")
    public String sell(@RequestParam("id") Long id) {
        service.sell(id);
        return "redirect:/stock/buyList";
    }
}

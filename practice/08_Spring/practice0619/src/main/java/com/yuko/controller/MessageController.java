package com.yuko.controller;

import com.yuko.dto.MessageDTO;
import com.yuko.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send")
@RequiredArgsConstructor
@Log4j2
public class MessageController {

    private final MessageService messageService;

    @PostMapping("")
    public ResponseEntity<String> create(MessageDTO message) {
        String result = messageService.sendMessage(message);
        return ResponseEntity.ok(result);
    }
}

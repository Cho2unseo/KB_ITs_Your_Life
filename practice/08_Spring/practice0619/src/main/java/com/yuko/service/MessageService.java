package com.yuko.service;

import com.yuko.dto.MessageDTO;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String sendMessage(MessageDTO message) {
        return "메시지 전송 완료";
    }
}

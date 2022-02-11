package com.example.smsozeki.core.resource;

import com.example.smsozeki.core.entity.MessageEntity;
import com.example.smsozeki.core.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/send")
public class MessageResource {
    @Autowired
    private MessageService messageService;

    @PostMapping("/sms")
    public String sendMessage(@RequestBody MessageEntity messageEntity) throws Exception {
         return messageService.sendSMS(messageEntity);
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return messageService.test();
    }
}

package com.example.outletbot.service;

import com.example.outletbot.bot.service.BotAlertService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeAlertService.java
 * Date/time: 20 декабрь 2021 in 10:54
 */
@Slf4j
@Service
@AllArgsConstructor
public class EmployeeAlertService {
    private final BotAlertService service;


    public void sendSimpleAlert(String chatId, String message) {
        service.sendingMessage(chatId, message);
    }

}

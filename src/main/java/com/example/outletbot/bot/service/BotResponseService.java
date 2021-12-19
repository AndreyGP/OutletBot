package com.example.outletbot.bot.service;

import com.example.outletbot.model.Employee;
import com.example.outletbot.service.BaseEmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 5:39
 */
@Slf4j
@Service
@AllArgsConstructor
public class BotResponseService {
    BaseEmployeeService baseEmployeeService;

    public boolean containsEmployee(String chatId) {
        return baseEmployeeService.containsEmployee(chatId);
    }
}

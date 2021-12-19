package com.example.outletbot.service;

import com.example.outletbot.model.BaseEmployee;
import com.example.outletbot.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeService.java
 * Date/time: 19 декабрь 2021 in 5:44
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BaseEmployeeService {
    private final Map<String, Employee> newEmployees = new HashMap<>();
    private final BaseEmployee baseEmployee;

    public boolean containsEmployee(String chatId) {
        return newEmployees.containsKey(chatId);
    }

    public void addNewEmployee(Message inMessage) {
        newEmployees.put(inMessage.getChatId().toString(), baseEmployee.getNewEmployee(inMessage));
    }
}

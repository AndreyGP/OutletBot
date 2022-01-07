package com.example.outletbot.service;

import com.example.outletbot.bot.common.BotState;
import com.example.outletbot.common.EmployeeRole;
import com.example.outletbot.model.BaseEmployee;
import com.example.outletbot.model.Employee;
import com.example.outletbot.model.collation.EmployeeCollation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeService.java
 * Date/time: 19 декабрь 2021 in 5:44
 */
@Slf4j
@Service
public class BaseEmployeeService {
    private final Map<String, Employee> newEmployees = new HashMap<>();
    private final EmployeeCollationService collationService;
    private final BaseEmployee baseEmployee;
    private final EmployeeAlertService alertService;

    @Autowired
    public BaseEmployeeService(EmployeeCollationService collationService, BaseEmployee baseEmployee, EmployeeAlertService alertService) {
        this.collationService = collationService;
        this.baseEmployee = baseEmployee;
        this.alertService = alertService;
    }

    public EmployeeCollation getEmployeeCollationByChatId(String chatId) {
        return collationService.getEmployeeCollationByChatId(chatId);
    }

    public boolean isNewEmployee(String chatId) {
        return containsChatId(chatId);
    }

    public boolean containsInBD(String chatId) {
        return getEmployeeCollationByChatId(chatId) != null;
    }

    public boolean isInitSystem(String chatId) {
        return (newEmployees.isEmpty() && collationService.getCountEmployee() == 0);
    }

    public void addSuperuser(String chatId) {
        alertService.sendSimpleAlert(chatId, "System initialisation mode");
        sleep(3000);
        alertService.sendSimpleAlert(chatId, "System initialisation success");
        sleep(2000);
        alertService.sendSimpleAlert(chatId, "Superuser initialisation mode");
        collationService.addNewEmployeeCollation(collationService.createSuperuserCollation(chatId));
        sleep(3000);
        alertService.sendSimpleAlert(chatId, "Superuser initialisation access");
        sleep(2000);
        alertService.sendSimpleAlert(chatId, "The system is ready to work");
        sleep(1500);
    }

    public void changeStateBot(String chatId, BotState botState) {
        collationService.changeStateBot(chatId, botState);
    }

    private boolean containsChatId(String chatId) {
        return newEmployees.containsKey(chatId);
    }

    public void addNewEmployee(Update update) {

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

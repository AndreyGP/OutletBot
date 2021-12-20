package com.example.outletbot.service;

import com.example.outletbot.bot.common.BotState;
import com.example.outletbot.common.EmployeeRole;
import com.example.outletbot.model.BaseEmployee;
import com.example.outletbot.model.Employee;
import com.example.outletbot.model.collation.EmployeeCollation;
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
    private final Map<String, Employee> employees = new HashMap<>();
    private final EmployeeCollationService collationService;
    private final BaseEmployee baseEmployee;
    private final EmployeeAlertService alertService;

    public boolean isSuperuser(String chatId) {
        return employees.get(chatId).getEmployeeRole() == EmployeeRole.DEV;
    }

    public boolean containsEmployee(String chatId) {
        if (employees.containsKey(chatId)) {
            return true;
        }  else if (collationService.getCountEmployee() == 0 && employees.isEmpty()) {
            addNewSuperuser(chatId);
            systemInitAlert(chatId);
            return true;
        }
        EmployeeCollation employeeCollation = collationService.getEmployeeCollationByChatId(chatId);
        return employeeCollation == null;
    }

    public void addNewEmployee(Message inMessage) {
        employees.put(inMessage.getChatId().toString(), baseEmployee.getNewEmployee(inMessage));
    }

    private void addNewSuperuser(String chatId) {
        EmployeeCollation superuser = new EmployeeCollation();
        superuser.setChatId(chatId);
        superuser.setEmployeeRole(EmployeeRole.DEV.getEmployeeRole());
        superuser.setBotState(BotState.DEV_MANE_MENU.getBotState());
        collationService.addNewEmployeeCollation(superuser);
        employees.put(chatId, createNewEmployee(superuser));
    }

    private Employee createNewEmployee(EmployeeCollation collation) {
        Employee newEmployee = new BaseEmployee();
        newEmployee.setChatId(collation.getChatId());
        newEmployee.setEmployeeRole(EmployeeRole.valueOf(collation.getEmployeeRole()));
        newEmployee.setBotState(BotState.valueOf(collation.getBotState()));
        return newEmployee;
    }

    private void systemInitAlert(String chatId) {
        alertService.sendSimpleAlert(chatId, "reply.systemInit");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alertService.sendSimpleAlert(chatId, "reply.newDevAdded");
    }
}

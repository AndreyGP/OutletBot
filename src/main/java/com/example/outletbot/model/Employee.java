package com.example.outletbot.model;

import com.example.outletbot.bot.common.BotState;
import com.example.outletbot.common.EmployeeRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: Employee.java
 * Date/time: 19 декабрь 2021 in 5:45
 */
@Slf4j
@Data
@EqualsAndHashCode
@ToString
@Component
public abstract class Employee {
    private EmployeeRole employeeRole;
    private BotState botState;
    private String chatId;
    private String phoneNumber;
    private String username;
    private String fullName;
    private String firstName;
    private String lastName;
    private Outlet baseOutlet;
    private Outlet currentOutlet;

    public abstract Employee getNewEmployee(Message inMessage);
}

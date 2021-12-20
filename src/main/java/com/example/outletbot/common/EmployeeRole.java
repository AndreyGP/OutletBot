package com.example.outletbot.common;

import com.example.outletbot.bot.common.BotState;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeRole.java
 * Date/time: 19 декабрь 2021 in 6:10
 */
@Getter
public enum EmployeeRole {
    NEW("Новый"),
    TRAINEE("Стажёр"),
    PICKER("Сборщик"),
    COURIER("Курьер"),
    SENIOR("Старший"),
    SUPER("Супервайзер"),
    DEV("Суперпользователь");

    private final String employeeRole;

    EmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public static EmployeeRole fromString(String employeeRole) {
        return Arrays.stream(EmployeeRole.values())
                .filter(t -> t.getEmployeeRole().equals(employeeRole))
                .findFirst()
                .orElse(NEW);
    }
}

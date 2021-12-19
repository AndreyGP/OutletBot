package com.example.outletbot.common;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeRole.java
 * Date/time: 19 декабрь 2021 in 6:10
 */
@Component
@AllArgsConstructor
public enum EmployeeRole {
    NEW("Новый пользователь"),
    TRAINEE("Стажёр"),
    PICKER("Сборщик"),
    COURIER("Курьер"),
    SENIOR("Старший"),
    SUPER("Супервайзер"),
    DEV("Разработчик");

    private final String employeeRole;

}

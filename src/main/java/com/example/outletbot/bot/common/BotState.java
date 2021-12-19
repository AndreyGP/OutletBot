package com.example.outletbot.bot.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotState.java
 * Date/time: 19 декабрь 2021 in 4:07
 */
@Getter
@Component
@RequiredArgsConstructor
public enum BotState {
    START,
    ADD_SUPER,
    SUPER_REGISTRATION,
    PHONE_SUPER_REGISTRATION,
    FULL_NAME_SUPER_REGISTRATION,
    SUPER_REGISTRATION_SUCCESS,
    HELLO_NEW_SUPER,
    INIT_NUMBER_OUTLET,
    ADD_SENIOR,
    ADD_SENIOR_PHONE,
    ADD_SENIOR_FULL_NAME,
    ADD_SENIOR_SUCCESS,
    INIT_OUTLET_SUCCESS,
    INTERVAL_FILTER,
    STATUS_FILTER,
    COURIER_FILTER,
    PICKER_FILTER,
    DEV_DEBAG,
    DEV_MANE_MENU,
    MAIN_MENU_DEFAULT,
    MAIN_MENU_SUPER,
    MAIN_MENU_SENIOR,
    REFRESH_DATA_SUCCESS,
    FAQ,
    YOU_NOT_FOUND,
    UN_CORRECT_COMMAND
}

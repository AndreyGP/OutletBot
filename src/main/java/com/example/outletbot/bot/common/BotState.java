package com.example.outletbot.bot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotState.java
 * Date/time: 19 декабрь 2021 in 4:07
 */
@Getter
public enum BotState {
    START("start"),
    ADD_SUPER("add_super"),
    SUPER_REGISTRATION("super_registration"),
    PHONE_SUPER_REGISTRATION("phone_super_registration"),
    FULL_NAME_SUPER_REGISTRATION("full_name_super_registration"),
    SUPER_REGISTRATION_SUCCESS("super_registration_success"),
    HELLO_NEW_SUPER("hello_new_super"),
    INIT_NUMBER_OUTLET("init_number_outlet"),
    ADD_SENIOR("add_senior"),
    ADD_SENIOR_PHONE("add_senior_phone"),
    ADD_SENIOR_FULL_NAME("add_senior_full_name"),
    ADD_SENIOR_SUCCESS("add_senior_success"),
    INIT_OUTLET_SUCCESS("init_outlet_success"),
    INTERVAL_FILTER("interval_filter"),
    STATUS_FILTER("status_filter"),
    COURIER_FILTER("courier_filter"),
    PICKER_FILTER("picker_filter"),
    DEV_DEBUG("dev_debug"),
    DEV_MANE_MENU("dev_mane_menu"),
    MAIN_MENU_DEFAULT("main_menu_default"),
    MAIN_MENU_SUPER("main_menu_super"),
    MAIN_MENU_SENIOR("main_menu_senior"),
    REFRESH_DATA_SUCCESS("refresh_data_success"),
    FAQ("faq"),
    YOU_NOT_FOUND("you_not_found"),
    UN_CORRECT_COMMAND("un_correct_command");

    private final String botState;

    BotState(String botState) {
        this.botState = botState;
    }

    public static BotState fromString(String botState) {
        return Arrays.stream(BotState.values())
                .filter(t -> t.getBotState().equals(botState))
                .findFirst()
                .orElse(BotState.MAIN_MENU_DEFAULT);
    }
}

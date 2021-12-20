package com.example.outletbot.bot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotCommandType.java
 * Date/time: 19 декабрь 2021 in 4:48
 */
@Getter
public enum BotCommandType {
    START("/start"),
    HELP("/help"),
    MAIN_MENU("/main_menu"),
    FEEDBACK("/feedback"),
    CLEAR("/clear"),
    CLEAR_ALL("/clear_all");

    private final String command;

    BotCommandType(String command) {
        this.command = command;
    }
}

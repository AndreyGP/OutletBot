package com.example.outletbot.bot.service;

import com.example.outletbot.bot.handler.CommandTypeHandler;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 3:53
 */
@Slf4j
@Service
@AllArgsConstructor
public class BotRequestService {
    CommandTypeHandler commandTypeHandler;
    BotResponseService service;

    public BotApiMethod<?> botCommand(Update update) {
        switch (commandTypeHandler.getCommandType(update)) {
            case START:
            case HELP:
            case MAIN_MENU:
            case FEEDBACK:
            case CLEAR:
            case CLEAR_ALL:
            default:
        }
        return null;
    }
    public BotApiMethod<?> phoneNumber(Update update) {
        return null;
    }
    public BotApiMethod<?> plainText(Update update) {
        return null;
    }
    public BotApiMethod<?> document(Update update) {
        return null;
    }
    public BotApiMethod<?> callback(Update update) {
        return null;
    }
    public BotApiMethod<?> other(Update update) {
        return null;
    }
}

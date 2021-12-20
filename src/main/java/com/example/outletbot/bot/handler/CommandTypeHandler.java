package com.example.outletbot.bot.handler;

import com.example.outletbot.bot.common.BotCommandType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: CommandTypeHandler.java
 * Date/time: 19 декабрь 2021 in 5:06
 */
@Component
public class CommandTypeHandler {


    public BotCommandType getCommandType(Update update) {
        return BotCommandType.fromString(update.getMessage().getText());
    }
}

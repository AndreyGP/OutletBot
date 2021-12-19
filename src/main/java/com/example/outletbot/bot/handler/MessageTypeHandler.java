package com.example.outletbot.bot.handler;

import com.example.outletbot.bot.common.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: MessageTypeHandler.java
 * Date/time: 19 декабрь 2021 in 3:22
 */
@Slf4j
@Component
public class MessageTypeHandler {

    public MessageType getMessageType(Update update) {
        if (update.hasCallbackQuery())
            return MessageType.CALLBACK;
        if (update.hasMessage() && update.getMessage().hasDocument())
            return  MessageType.DOCUMENT;
        if (update.hasMessage() && update.getMessage().hasEntities()) {
            if (update.getMessage().getEntities().get(0).getType().equals("phone_number"))
                return MessageType.PHONE_NUMBER;
            if (update.getMessage().getEntities().get(0).getType().equals("bot_command"))
                return MessageType.BOT_COMMAND;
        }
        if (update.hasMessage() && update.getMessage().hasText())
            return MessageType.PLAIN_TEXT;
        return MessageType.OTHER;
    }

}

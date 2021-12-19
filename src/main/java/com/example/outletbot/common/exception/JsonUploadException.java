package com.example.outletbot.common.exception;

import com.example.outletbot.bot.WebHookOutletBot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: JsonUploadException.java
 * Date/time: 19 декабрь 2021 in 6:29
 */

public class JsonUploadException extends Exception {
    private final WebHookOutletBot bot;
    private final String chatId;
    private final String errorMessage;

    public JsonUploadException(final WebHookOutletBot bot, final String chatId, final String errorMessage) {
        this.bot = bot;
        this.chatId = chatId;
        this.errorMessage = errorMessage;
        sendExceptionMessage();
    }

    private void sendExceptionMessage() {
        bot.sendingMessage(
                SendMessage.builder()
                        .chatId(chatId)
                        .text(errorMessage)
                        .build()
        );
    }
}

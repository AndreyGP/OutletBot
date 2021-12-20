package com.example.outletbot.common.exception;

import com.example.outletbot.bot.service.BotAlertService;
import com.example.outletbot.bot.service.BotServiceImpl;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: JsonUploadException.java
 * Date/time: 19 декабрь 2021 in 6:29
 */

public class JsonUploadException extends Exception {
    private final BotAlertService service;
    private final String chatId;
    private final String errorMessage;

    public JsonUploadException(final BotAlertService service, final String chatId, final String errorMessage) {
        this.service = service;
        this.chatId = chatId;
        this.errorMessage = errorMessage;
        sendExceptionMessage();
    }

    private void sendExceptionMessage() {
//        service.sendingMessage(
//                SendMessage.builder()
//                        .chatId(chatId)
//                        .text(errorMessage)
//                        .build()
//        );
    }
}

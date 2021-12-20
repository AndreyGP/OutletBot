package com.example.outletbot.bot.service;

import com.example.outletbot.bot.WebHookOutletBot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotAlertService.java
 * Date/time: 20 декабрь 2021 in 10:55
 */
@Slf4j
@Service
public class BotAlertService {

    private final WebHookOutletBot bot;

    @Lazy
    public BotAlertService(WebHookOutletBot bot) {
        this.bot = bot;
    }

    public void sendingMessage(final String chatId, final String message) {
        final SendMessage newMessage = SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .build();
        try {
            bot.execute(newMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendingMessage(SendMessage message) {
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

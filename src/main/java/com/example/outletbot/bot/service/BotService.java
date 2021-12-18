package com.example.outletbot.bot.service;

import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.WebhookBot;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotService.java
 * Date/time: 19 декабрь 2021 in 2:23
 */

public interface BotService extends WebhookBot {
    @Override
    default void setWebhook(SetWebhook setWebhook) throws TelegramApiException {

    }
    @Override
    default String getBotPath() {
        return null;
    }

    @Override
    default String getBotUsername() {
        return null;
    }

    @Override
    default String getBotToken() {
        return null;
    }
}

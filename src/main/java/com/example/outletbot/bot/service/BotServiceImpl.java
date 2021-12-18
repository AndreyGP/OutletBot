package com.example.outletbot.bot.service;

import com.example.outletbot.bot.WebHookOutletBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.WebhookBot;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotService.java
 * Date/time: 19 декабрь 2021 in 1:47
 */
@Slf4j
@Service
public class BotServiceImpl implements BotService {
    private final WebHookOutletBot bot;

    @Lazy
    public BotServiceImpl(WebHookOutletBot bot) {
        this.bot = bot;
    }


    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    public void sendingMessage(SendMessage message) {
        log.info("Test message start sending...\n");
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            log.info("Fucking catch!");
            e.printStackTrace();
        }
        log.info("Sending successful!");
    }
}

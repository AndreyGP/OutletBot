package com.example.outletbot.bot;

import com.example.outletbot.bot.config.BotConfiguration;
import com.example.outletbot.bot.service.BotServiceImpl;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: WebHookOutletBot.java
 * Date/time: 19 декабрь 2021 in 1:17
 */
@Slf4j
@Setter
public class WebHookOutletBot extends SpringWebhookBot {
    private final BotConfiguration botConfig;
    private final BotServiceImpl service;
    
    @Autowired
    public WebHookOutletBot(BotServiceImpl botService, BotConfiguration botConfiguration) {
        super(botConfiguration.setWebhook());
        botConfig = botConfiguration;
        service = botService;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotUserName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return service.onWebhookUpdateReceived(update);
    }

    @Override
    public String getBotPath() {
        return botConfig.getWebHookPath();
    }

}

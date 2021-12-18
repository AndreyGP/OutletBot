package com.example.outletbot.controller;

import com.example.outletbot.bot.WebHookOutletBot;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: null.java
 * Date/time: 19 декабрь 2021 in 2:35
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BotController {
    private final WebHookOutletBot bot;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return bot.onWebhookUpdateReceived(update);
    }
}

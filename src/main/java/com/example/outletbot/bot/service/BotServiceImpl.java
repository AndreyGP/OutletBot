package com.example.outletbot.bot.service;

import com.example.outletbot.bot.handler.MessageTypeHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotService.java
 * Date/time: 19 декабрь 2021 in 1:47
 */
@Slf4j
@Service
@AllArgsConstructor
public class BotServiceImpl implements BotService {
    private final MessageTypeHandler typeHandler;
    private final BotRequestService requestService;

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return getResponse(update);
    }

    private BotApiMethod<?> getResponse(Update update) {
        switch (typeHandler.getMessageType(update)) {
            case BOT_COMMAND:
                return requestService.botCommand(update);
            case PHONE_NUMBER:
                requestService.phoneNumber(update);
                break;
            case PLAIN_TEXT:
                requestService.plainText(update);
                break;
            case DOCUMENT:
                requestService.document(update);
                break;
            case CALLBACK:
                requestService.callback(update);
                break;
            case OTHER:
                requestService.other(update);
                break;
            default:
                return null;
        }
        return null;
    }
}

package com.example.outletbot.bot.service;

import com.example.outletbot.bot.handler.CommandTypeHandler;
import com.example.outletbot.service.BaseEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 3:53
 */
@Slf4j
@Service
//@AllArgsConstructor
public class BotRequestService {
    private final CommandTypeHandler commandTypeHandler;
    private final BotResponseService service;
    private final BaseEmployeeService baseEmployeeService;

    @Autowired
    public BotRequestService(CommandTypeHandler commandTypeHandler, BotResponseService service, BaseEmployeeService baseEmployeeService) {
        this.commandTypeHandler = commandTypeHandler;
        this.service = service;
        this.baseEmployeeService = baseEmployeeService;
    }


    public BotApiMethod<?> botCommand(Update update) {
        switch (commandTypeHandler.getCommandType(update)) {
            case START:
                return startBotCommandContext(update);
            case HELP:
            case MAIN_MENU:
            case FEEDBACK:
            case CLEAR:
            case CLEAR_ALL:
            default:
        }
        return null;
    }

    public BotApiMethod<?> phoneNumber(Update update) {
        return null;
    }

    public BotApiMethod<?> plainText(Update update) {
        return null;
    }

    public BotApiMethod<?> document(Update update) {
        return null;
    }

    public BotApiMethod<?> callback(Update update) {
        return null;
    }

    public BotApiMethod<?> other(Update update) {
        return null;
    }

    private BotApiMethod<?> startBotCommandContext(Update update) {
        String chatId = update.getMessage().getChatId().toString();
//        return service.replyPhoneQuestion(chatId); Success
//        return service.getMainMenuReply(chatId); Success
//        return service.systemLaunch(chatId); Success
//        return service.getHelloMessage(chatId); Success

        if (baseEmployeeService.isNewEmployee(chatId)) {
            return service.replyPhoneQuestion(chatId);
        } else if (baseEmployeeService.containsInBD(chatId)) {
            return service.getMainMenuReply(chatId);
        } else if (baseEmployeeService.isInitSystem(chatId)) {
            return service.systemLaunch(chatId);
        }
        return service.getHelloMessage(chatId);
    }
}

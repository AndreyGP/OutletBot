package com.example.outletbot.bot.service;

import com.example.outletbot.service.BaseEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 5:39
 */
@Slf4j
@Service
public class BotResponseService {
    private final BaseEmployeeService baseEmployeeService;
    private final BotKeyboardReplyService botKeyboardReplyService;
    @Value( "${reply.start}" )
    private String startMessage;
    @Value( "${reply.phoneNumberRequest}" )
    private String phoneNumberRequestMessage;
    @Value( "${reply.selectDisplayMode}" )
    private String selectDisplayMode;

    @Autowired
    public BotResponseService(BaseEmployeeService baseEmployeeService, BotKeyboardReplyService botKeyboardReplyService) {
        this.baseEmployeeService = baseEmployeeService;
        this.botKeyboardReplyService = botKeyboardReplyService;
    }

    public BotApiMethod<?> getHelloMessage(String chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(startMessage)
                .build();
    }

    public BotApiMethod<?> replyPhoneQuestion(String chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(phoneNumberRequestMessage)
                .build();
    }

    public BotApiMethod<?> getMainMenuReply(String chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(selectDisplayMode)
                .replyMarkup(botKeyboardReplyService.getInlineMainMenu())
                .build();
    }

    public BotApiMethod<?> systemLaunch(String chatId) {


        return SendMessage.builder()
                .chatId(chatId)
                .text("Select mode")
                .replyMarkup(botKeyboardReplyService.getInlineSuperuserMainMenu())
                .build();
    }
}

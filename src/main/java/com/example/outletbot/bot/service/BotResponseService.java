package com.example.outletbot.bot.service;

import com.example.outletbot.bot.common.BotState;
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
    @Value("${reply.superuserMainMenu}")
    private String superuserMainMenu;
    @Value("${reply.replyFullNameSuper}")
    private String replyFullNameSuper;
    @Value("${reply.debugInfo}")
    private String debugInfo;
    @Value("${reply.replyPhoneSuper}")
    private String replyPhoneSuper;
    @Value("${reply.youNotFound}")
    private String youNotFound;

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

    public BotApiMethod<?> getMainMenuReply(String chatId, boolean isSuperuser) {
        baseEmployeeService.changeStateBot(chatId, BotState.MAIN_MENU_DEFAULT);
        return SendMessage.builder()
                .chatId(chatId)
                .text(selectDisplayMode)
                .replyMarkup(botKeyboardReplyService.getInlineMainMenu(isSuperuser))
                .build();
    }

    public BotApiMethod<?> systemLaunch(String chatId) {
        baseEmployeeService.addSuperuser(chatId);
        return getInlineSuperuserMainMenu(chatId);
    }

    public BotApiMethod<?> getInlineSuperuserMainMenu (String chatId) {
        baseEmployeeService.changeStateBot(chatId, BotState.DEV_MANE_MENU);
        return SendMessage.builder()
                .chatId(chatId)
                .text(superuserMainMenu)
                .replyMarkup(botKeyboardReplyService.getInlineSuperuserMainMenu())
                .build();
    }

    public BotApiMethod<?> replyFullNameSuper(String chatId) {
        baseEmployeeService.changeStateBot(chatId, BotState.ADD_SUPER);
        return SendMessage.builder()
                .chatId(chatId)
                .text(replyFullNameSuper)
                .replyMarkup(botKeyboardReplyService.getCancelMenu())
                .build();
    }

    public BotApiMethod<?> getDebugInfo(String chatId) {
        baseEmployeeService.changeStateBot(chatId, BotState.DEV_DEBUG);
        return SendMessage.builder()
                .chatId(chatId)
                .text(debugInfo)
                .replyMarkup(botKeyboardReplyService.getCancelMenu())
                .build();
    }

    public BotApiMethod<?> replyPhoneSupervisor(String chatId) {
        baseEmployeeService.changeStateBot(chatId, BotState.PHONE_SUPER_REGISTRATION);
        return SendMessage.builder()
                .chatId(chatId)
                .text(replyPhoneSuper)
                .replyMarkup(botKeyboardReplyService.getCancelMenu())
                .build();
    }

    public BotApiMethod<?> youNotFound(String chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(youNotFound)
                .build();
    }
}

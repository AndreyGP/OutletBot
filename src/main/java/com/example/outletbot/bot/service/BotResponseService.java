package com.example.outletbot.bot.service;

import com.example.outletbot.service.BaseEmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 5:39
 */
@Slf4j
@Service
@AllArgsConstructor
public class BotResponseService {
    private final BaseEmployeeService baseEmployeeService;
    private final BotAlertService botAlertService;
    private final BotKeyboardReplyService botKeyboardReplyService;

    public boolean containsEmployee(String chatId) {
        return baseEmployeeService.containsEmployee(chatId);
    }

    public BotApiMethod<?> helloNewEmployee(Message inMessage) {
        SendMessage helloResponse = getBasicAnswer(inMessage.getChatId().toString());
        helloResponse.setText("reply.start");
        baseEmployeeService.addNewEmployee(inMessage);
        return helloResponse;
    }

    public BotApiMethod<?> responseIfSuperuser(String chatId) {
        if (baseEmployeeService.isSuperuser(chatId)) {
            SendMessage message = getBasicAnswer(chatId);
            message.setText("reply.superuserMainMenu");
            message.enableMarkdown(true);
            message.setReplyMarkup(botKeyboardReplyService.getInlineSuperuserMainMenu());
            return message;
        }
        return null;
    }

    private SendMessage getBasicAnswer(String chatId) {
        return SendMessage.builder()
                .chatId(chatId)
                .build();
    }
}

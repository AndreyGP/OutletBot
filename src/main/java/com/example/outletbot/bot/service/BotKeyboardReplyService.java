package com.example.outletbot.bot.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotKeyboardReplyService.java
 * Date/time: 20 декабрь 2021 in 12:36
 */
@Slf4j
@Service
@AllArgsConstructor
public class BotKeyboardReplyService {

    public InlineKeyboardMarkup getInlineSuperuserMainMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton addSupervisorButton = new InlineKeyboardButton();
        addSupervisorButton.setText("New Super");
        InlineKeyboardButton mainMenu = new InlineKeyboardButton();
        mainMenu.setText("Main");

        addSupervisorButton.setCallbackData("addSuper");
        mainMenu.setCallbackData("mainMenu");

        List<InlineKeyboardButton> keyboardButtons = new ArrayList<>();
        keyboardButtons.add(addSupervisorButton);
        keyboardButtons.add(mainMenu);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtons);

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }
}

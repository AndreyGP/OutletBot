package com.example.outletbot.bot.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
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
        addSupervisorButton.setCallbackData("addNewSupervisor");
        InlineKeyboardButton mainMenu = new InlineKeyboardButton();
        mainMenu.setText("Main");
        mainMenu.setCallbackData("mainMenuDev");

        List<InlineKeyboardButton> keyboardButtons = new ArrayList<>();
        keyboardButtons.add(addSupervisorButton);
        keyboardButtons.add(mainMenu);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtons);

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }

    public ReplyKeyboard getInlineMainMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton courier = new InlineKeyboardButton();
        courier.setText("\uD83D\uDE9B");
        courier.setCallbackData("mainMenuCourier");
        InlineKeyboardButton status = new InlineKeyboardButton();
        status.setText("\uD83D\uDCCA");
        status.setCallbackData("mainMenuStatus");
        InlineKeyboardButton interval = new InlineKeyboardButton();
        interval.setText("⏰");
        interval.setCallbackData("mainMenuInterval");
        InlineKeyboardButton picker = new InlineKeyboardButton();
        picker.setText("\uD83D\uDED2");
        picker.setCallbackData("mainMenuPicker");

        List<InlineKeyboardButton> keyboardButtons = new ArrayList<>();
        keyboardButtons.add(courier);
        keyboardButtons.add(status);
        keyboardButtons.add(interval);
        keyboardButtons.add(picker);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtons);

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }
}

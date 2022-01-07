package com.example.outletbot.bot.service;

import com.example.outletbot.bot.common.BotState;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
//@AllArgsConstructor
public class BotKeyboardReplyService {
    @Value("${button.mainMenuCourier}")
    private String mainMenuCourier;
    @Value("${button.mainMenuStatus}")
    private String mainMenuStatus;
    @Value("${button.mainMenuInterval}")
    private String mainMenuInterval;
    @Value("${button.mainMenuPicker}")
    private String mainMenuPicker;
    @Value("${button.cancelText}")
    private String cancelText;
    @Value("${button.superuserMode}")
    private String superuserMode;
    @Value("${button.newSupervisor}")
    private String newSupervisor;
    @Value("${button.outletMenu}")
    private String outletMenu;
    @Value("${button.debugInfo}")
    private String debugInfo;

    public InlineKeyboardMarkup getInlineSuperuserMainMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton addSupervisorButton = new InlineKeyboardButton();
        addSupervisorButton.setText(newSupervisor);
        addSupervisorButton.setCallbackData(BotState.ADD_SUPER.getBotState());
        InlineKeyboardButton mainMenu = new InlineKeyboardButton();
        mainMenu.setText(outletMenu);
        mainMenu.setCallbackData(BotState.MAIN_MENU_DEFAULT.getBotState());
        InlineKeyboardButton debug = new InlineKeyboardButton();
        debug.setText(debugInfo);
        debug.setCallbackData(BotState.DEV_DEBUG.getBotState());

        List<InlineKeyboardButton> firstRow = new ArrayList<>();
        firstRow.add(addSupervisorButton);
        firstRow.add(mainMenu);

        List<InlineKeyboardButton> secondRow = new ArrayList<>();
        secondRow.add(debug);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(firstRow);
        buttons.add(secondRow);

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }

    public ReplyKeyboard getInlineMainMenu(boolean isSuperuser) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton courier = new InlineKeyboardButton();
        courier.setText(mainMenuCourier);
        courier.setCallbackData(BotState.COURIER_FILTER.getBotState());
        InlineKeyboardButton status = new InlineKeyboardButton();
        status.setText(mainMenuStatus);
        status.setCallbackData(BotState.STATUS_FILTER.getBotState());
        InlineKeyboardButton interval = new InlineKeyboardButton();
        interval.setText(mainMenuInterval);
        interval.setCallbackData(BotState.INTERVAL_FILTER.getBotState());
        InlineKeyboardButton picker = new InlineKeyboardButton();
        picker.setText(mainMenuPicker);
        picker.setCallbackData(BotState.PICKER_FILTER.getBotState());

        List<InlineKeyboardButton> keyboardButtons = new ArrayList<>();
        keyboardButtons.add(courier);
        keyboardButtons.add(status);
        keyboardButtons.add(interval);
        keyboardButtons.add(picker);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(keyboardButtons);

        if (isSuperuser) {
            InlineKeyboardButton devMainMenu = new InlineKeyboardButton();
            devMainMenu.setText(superuserMode);
            devMainMenu.setCallbackData(BotState.DEV_MANE_MENU.getBotState());
            List<InlineKeyboardButton> keyboardButtons2 = new ArrayList<>();
            keyboardButtons2.add(devMainMenu);
            buttons.add(keyboardButtons2);
        }

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }

    public ReplyKeyboard getCancelMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton cancel = new InlineKeyboardButton();
        cancel.setText(cancelText);
        cancel.setCallbackData(BotState.DEV_MANE_MENU.getBotState());

        List<InlineKeyboardButton> firstRow = new ArrayList<>();
        firstRow.add(cancel);

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(firstRow);

        inlineKeyboardMarkup.setKeyboard(buttons);

        return inlineKeyboardMarkup;
    }
}

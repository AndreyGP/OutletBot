package com.example.outletbot.bot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@ContextConfiguration(classes = {BotKeyboardReplyService.class})
@ExtendWith(SpringExtension.class)
class BotKeyboardReplyServiceTest {
    @Autowired
    private BotKeyboardReplyService botKeyboardReplyService;

    @Test
    void testGetInlineSuperuserMainMenu() {
        InlineKeyboardMarkup actualInlineSuperuserMainMenu = this.botKeyboardReplyService.getInlineSuperuserMainMenu();
        List<List<InlineKeyboardButton>> keyboard = actualInlineSuperuserMainMenu.getKeyboard();
        assertEquals(1, keyboard.size());
        assertEquals(
                "InlineKeyboardMarkup(keyboard=[[InlineKeyboardButton(text=New Super, url=null, callbackData=addNewSupervisor,"
                        + " callbackGame=null, switchInlineQuery=null, switchInlineQueryCurrentChat=null, pay=null, loginUrl=null),"
                        + " InlineKeyboardButton(text=Main, url=null, callbackData=mainMenuDev, callbackGame=null, switchInlineQuery"
                        + "=null, switchInlineQueryCurrentChat=null, pay=null, loginUrl=null)]])",
                actualInlineSuperuserMainMenu.toString());
        assertEquals(2, keyboard.get(0).size());
    }

    @Test
    void testGetInlineMainMenu() {
        ReplyKeyboard actualInlineMainMenu = this.botKeyboardReplyService.getInlineMainMenu();
        List<List<InlineKeyboardButton>> keyboard = ((InlineKeyboardMarkup) actualInlineMainMenu).getKeyboard();
        assertEquals(1, keyboard.size());
        assertEquals("InlineKeyboardMarkup(keyboard=[[InlineKeyboardButton(text=🚛, url=null, callbackData=mainMenuCourier,"
                + " callbackGame=null, switchInlineQuery=null, switchInlineQueryCurrentChat=null, pay=null, loginUrl=null),"
                + " InlineKeyboardButton(text=📊, url=null, callbackData=mainMenuStatus, callbackGame=null, switchInlineQuery"
                + "=null, switchInlineQueryCurrentChat=null, pay=null, loginUrl=null), InlineKeyboardButton(text=⏰,"
                + " url=null, callbackData=mainMenuInterval, callbackGame=null, switchInlineQuery=null, switchInlineQue"
                + "ryCurrentChat=null, pay=null, loginUrl=null), InlineKeyboardButton(text=🛒, url=null, callbackData"
                + "=mainMenuPicker, callbackGame=null, switchInlineQuery=null, switchInlineQueryCurrentChat=null, pay=null,"
                + " loginUrl=null)]])", actualInlineMainMenu.toString());
        assertEquals(4, keyboard.get(0).size());
    }
}


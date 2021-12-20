package com.example.outletbot.bot.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.config.BotConfiguration;
import com.example.outletbot.bot.handler.MessageTypeHandler;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiValidationException;

@ContextConfiguration(classes = {BotAlertService.class})
@ExtendWith(SpringExtension.class)
class BotAlertServiceTest {
    @Autowired
    private BotAlertService botAlertService;

    @MockBean
    private WebHookOutletBot webHookOutletBot;

    @Test
    void testSendingMessage() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(String, String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.botAlertService.sendingMessage("42", "Not all who wander are lost");
    }

    @Test
    void testSendingMessage2() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(String, String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        this.botAlertService.sendingMessage(
                "CGLIB$execute$33(Lorg/telegram/telegrambots/meta/api/methods/BotApiMethod;)Ljava/io/Serializable;",
                "Not all who wander are lost");
    }

    @Test
    void testSendingMessage3() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(SendMessage)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BotAlertService botAlertService = new BotAlertService(mock(WebHookOutletBot.class));
        botAlertService.sendingMessage(new SendMessage("42", "Text"));
    }

    @Test
    void testSendingMessage4() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(SendMessage)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        botAlertService.sendingMessage(new SendMessage("", "Text"));
    }

    @Test
    void testSendingMessage5() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(SendMessage)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        botAlertService.sendingMessage(new SendMessage("42", ""));
    }

    @Test
    void testSendingMessage6() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(SendMessage)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        botAlertService.sendingMessage(new SendMessage());
    }

    @Test
    void testSendingMessage7() throws TelegramApiValidationException {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        ReplyKeyboard replyKeyboard = mock(ReplyKeyboard.class);
        doNothing().when(replyKeyboard).validate();
        botAlertService.sendingMessage(new SendMessage("42", "Text", "Parse Mode", true, true, 123, replyKeyboard,
                new ArrayList<MessageEntity>(), true));
        verify(replyKeyboard).validate();
    }

    @Test
    void testSendingMessage8() throws TelegramApiValidationException {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by sendingMessage(SendMessage)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        ReplyKeyboard replyKeyboard = mock(ReplyKeyboard.class);
        doNothing().when(replyKeyboard).validate();

        ArrayList<MessageEntity> messageEntityList = new ArrayList<MessageEntity>();
        messageEntityList.add(new MessageEntity());
        botAlertService.sendingMessage(
                new SendMessage("42", "Text", "Parse Mode", true, true, 123, replyKeyboard, messageEntityList, true));
    }

    @Test
    void testSendingMessage9() throws TelegramApiValidationException {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        BotAlertService botAlertService = new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration));
        SendMessage sendMessage = mock(SendMessage.class);
        when(sendMessage.getMethod()).thenReturn("Method");
        doNothing().when(sendMessage).validate();
        botAlertService.sendingMessage(sendMessage);
        verify(sendMessage, atLeast(1)).getMethod();
        verify(sendMessage).validate();
    }
}


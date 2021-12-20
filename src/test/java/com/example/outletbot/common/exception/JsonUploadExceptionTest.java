package com.example.outletbot.common.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.config.BotConfiguration;
import com.example.outletbot.bot.handler.MessageTypeHandler;
import com.example.outletbot.bot.service.BotAlertService;
import com.example.outletbot.bot.service.BotRequestService;
import com.example.outletbot.bot.service.BotServiceImpl;
import org.junit.jupiter.api.Test;

class JsonUploadExceptionTest {
    @Test
    void testConstructor() {
        JsonUploadException actualJsonUploadException = new JsonUploadException(
                new BotAlertService(mock(WebHookOutletBot.class)), "42", "An error occurred");

        assertNull(actualJsonUploadException.getCause());
        assertEquals("com.example.outletbot.common.exception.JsonUploadException", actualJsonUploadException.toString());
        assertEquals(0, actualJsonUploadException.getSuppressed().length);
        assertNull(actualJsonUploadException.getMessage());
        assertNull(actualJsonUploadException.getLocalizedMessage());
    }

    @Test
    void testConstructor2() {
        BotAlertService botAlertService = mock(BotAlertService.class);
        doNothing().when(botAlertService)
                .sendingMessage((org.telegram.telegrambots.meta.api.methods.send.SendMessage) any());
        new JsonUploadException(botAlertService, "42", "An error occurred");

        verify(botAlertService).sendingMessage((org.telegram.telegrambots.meta.api.methods.send.SendMessage) any());
    }

    @Test
    void testConstructor3() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        JsonUploadException actualJsonUploadException = new JsonUploadException(
                new BotAlertService(new WebHookOutletBot(
                        new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration)),
                "", "An error occurred");

        assertNull(actualJsonUploadException.getCause());
        assertEquals("com.example.outletbot.common.exception.JsonUploadException", actualJsonUploadException.toString());
        assertEquals(0, actualJsonUploadException.getSuppressed().length);
        assertNull(actualJsonUploadException.getMessage());
        assertNull(actualJsonUploadException.getLocalizedMessage());
    }

    @Test
    void testConstructor4() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        JsonUploadException actualJsonUploadException = new JsonUploadException(new BotAlertService(new WebHookOutletBot(
                new BotServiceImpl(typeHandler, new BotRequestService(null, null, null)), botConfiguration)), "42", "");

        assertNull(actualJsonUploadException.getCause());
        assertEquals("com.example.outletbot.common.exception.JsonUploadException", actualJsonUploadException.toString());
        assertEquals(0, actualJsonUploadException.getSuppressed().length);
        assertNull(actualJsonUploadException.getMessage());
        assertNull(actualJsonUploadException.getLocalizedMessage());
    }
}


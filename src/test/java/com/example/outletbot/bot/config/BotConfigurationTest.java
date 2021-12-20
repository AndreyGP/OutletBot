package com.example.outletbot.bot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.example.outletbot.bot.WebHookOutletBot;
import com.example.outletbot.bot.handler.CommandTypeHandler;
import com.example.outletbot.bot.handler.MessageTypeHandler;
import com.example.outletbot.bot.service.BotKeyboardReplyService;
import com.example.outletbot.bot.service.BotRequestService;
import com.example.outletbot.bot.service.BotResponseService;
import com.example.outletbot.bot.service.BotServiceImpl;
import com.example.outletbot.model.BaseEmployee;
import com.example.outletbot.repository.EmployeeMongoRepository;
import com.example.outletbot.service.BaseEmployeeService;
import com.example.outletbot.service.EmployeeAlertService;
import com.example.outletbot.service.EmployeeCollationService;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

class BotConfigurationTest {
    @Test
    void testDefaultBotOptions() {
        DefaultBotOptions actualDefaultBotOptionsResult = (new BotConfiguration()).defaultBotOptions();
        assertNull(actualDefaultBotOptionsResult.getProxyType());
        assertEquals(0, actualDefaultBotOptionsResult.getProxyPort());
        assertNull(actualDefaultBotOptionsResult.getProxyHost());
        assertEquals(1, actualDefaultBotOptionsResult.getMaxThreads());
        HttpContext httpContext = actualDefaultBotOptionsResult.getHttpContext();
        assertTrue(httpContext instanceof HttpClientContext);
        assertEquals(50, actualDefaultBotOptionsResult.getGetUpdatesTimeout());
        assertEquals(100, actualDefaultBotOptionsResult.getGetUpdatesLimit());
        assertEquals("https://api.telegram.org/bot", actualDefaultBotOptionsResult.getBaseUrl());
        assertNull(((HttpClientContext) httpContext).getTargetAuthState());
    }

    @Test
    void testSetWebhook() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        SetWebhook actualSetWebhookResult = botConfiguration.setWebhook();
        assertTrue(actualSetWebhookResult.getAllowedUpdates().isEmpty());
        assertEquals("Web Hook Path", actualSetWebhookResult.getUrl());
        assertNull(actualSetWebhookResult.getMaxConnections());
        assertNull(actualSetWebhookResult.getIpAddress());
        assertNull(actualSetWebhookResult.getDropPendingUpdates());
        assertNull(actualSetWebhookResult.getCertificate());
    }

    @Test
    void testWebHookOutletBot() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BaseEmployeeService baseEmployeeService = new BaseEmployeeService(null, null, null);

        BotResponseService service = new BotResponseService(baseEmployeeService, new BotKeyboardReplyService());

        EmployeeCollationService collationService = new EmployeeCollationService(mock(EmployeeMongoRepository.class));
        BaseEmployee baseEmployee = new BaseEmployee();
        WebHookOutletBot actualWebHookOutletBotResult = botConfiguration
                .webHookOutletBot(new BotServiceImpl(typeHandler, new BotRequestService(commandTypeHandler, service,
                        new BaseEmployeeService(collationService, baseEmployee, new EmployeeAlertService(null)))));
        assertEquals("https://api.telegram.org/botnull/", actualWebHookOutletBotResult.getBaseUrl());
        assertEquals("Web Hook Path", actualWebHookOutletBotResult.getBotPath());
        DefaultBotOptions options = actualWebHookOutletBotResult.getOptions();
        assertEquals(1, options.getMaxThreads());
        HttpContext httpContext = options.getHttpContext();
        assertTrue(httpContext instanceof HttpClientContext);
        assertEquals(50, options.getGetUpdatesTimeout());
        assertEquals(100, options.getGetUpdatesLimit());
        SetWebhook setWebhook = actualWebHookOutletBotResult.getSetWebhook();
        assertNull(setWebhook.getIpAddress());
        assertNull(setWebhook.getMaxConnections());
        assertTrue(setWebhook.getAllowedUpdates().isEmpty());
        assertEquals("Web Hook Path", setWebhook.getUrl());
        assertEquals(DefaultBotOptions.ProxyType.NO_PROXY, options.getProxyType());
        assertNull(setWebhook.getCertificate());
        assertNull(setWebhook.getDropPendingUpdates());
        assertEquals("https://api.telegram.org/bot", options.getBaseUrl());
        assertNull(((HttpClientContext) httpContext).getCookieOrigin());
    }
}


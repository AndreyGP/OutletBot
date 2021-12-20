package com.example.outletbot.bot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.outletbot.service.BaseEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@ContextConfiguration(classes = {BotResponseService.class})
@ExtendWith(SpringExtension.class)
class BotResponseServiceTest {
    @MockBean
    private BaseEmployeeService baseEmployeeService;

    @MockBean
    private BotKeyboardReplyService botKeyboardReplyService;

    @Autowired
    private BotResponseService botResponseService;

    @Test
    void testGetHelloMessage() {
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getAllowSendingWithoutReply());
        assertEquals("reply.start", ((SendMessage) this.botResponseService.getHelloMessage("42")).getText());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getReplyToMessageId());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getReplyMarkup());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getParseMode());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getEntities());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getDisableWebPagePreview());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("42")).getDisableNotification());
        assertEquals("42", ((SendMessage) this.botResponseService.getHelloMessage("42")).getChatId());
        assertEquals("reply.start", ((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getChatId());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getDisableNotification());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getDisableWebPagePreview());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getEntities());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getParseMode());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getReplyMarkup());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getReplyToMessageId());
        assertEquals("reply.start", ((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getText());
        assertNull(((SendMessage) this.botResponseService.getHelloMessage("reply.start")).getAllowSendingWithoutReply());
    }
}


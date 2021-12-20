package com.example.outletbot.bot.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.bot.common.MessageType;
import com.example.outletbot.bot.handler.MessageTypeHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.methods.groupadministration.ExportChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.Update;

@ContextConfiguration(classes = {BotServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BotServiceImplTest {
    @MockBean
    private BotRequestService botRequestService;

    @Autowired
    private BotServiceImpl botServiceImpl;

    @MockBean
    private MessageTypeHandler messageTypeHandler;

    @Test
    void testOnWebhookUpdateReceived() {
        when(this.messageTypeHandler.getMessageType((Update) any())).thenReturn(MessageType.PLAIN_TEXT);
//        when(this.botRequestService.plainText((Update) any())).thenReturn(new ExportChatInviteLink("42"));
        assertNull(this.botServiceImpl.onWebhookUpdateReceived(new Update()));
        verify(this.messageTypeHandler).getMessageType((Update) any());
        verify(this.botRequestService).plainText((Update) any());
    }

    @Test
    void testOnWebhookUpdateReceived2() {
        when(this.messageTypeHandler.getMessageType((Update) any())).thenReturn(MessageType.BOT_COMMAND);
        ExportChatInviteLink exportChatInviteLink = new ExportChatInviteLink("42");
//        when(this.botRequestService.botCommand((Update) any())).thenReturn(exportChatInviteLink);
//        when(this.botRequestService.plainText((Update) any())).thenReturn(new ExportChatInviteLink("42"));
        assertSame(exportChatInviteLink, this.botServiceImpl.onWebhookUpdateReceived(new Update()));
        verify(this.messageTypeHandler).getMessageType((Update) any());
        verify(this.botRequestService).botCommand((Update) any());
    }

    @Test
    void testOnWebhookUpdateReceived3() {
        when(this.messageTypeHandler.getMessageType((Update) any())).thenReturn(MessageType.PHONE_NUMBER);
//        when(this.botRequestService.phoneNumber((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.botCommand((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.plainText((Update) any())).thenReturn(new ExportChatInviteLink("42"));
        assertNull(this.botServiceImpl.onWebhookUpdateReceived(new Update()));
        verify(this.messageTypeHandler).getMessageType((Update) any());
        verify(this.botRequestService).phoneNumber((Update) any());
    }

    @Test
    void testOnWebhookUpdateReceived4() {
        when(this.messageTypeHandler.getMessageType((Update) any())).thenReturn(MessageType.DOCUMENT);
//        when(this.botRequestService.document((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.phoneNumber((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.botCommand((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.plainText((Update) any())).thenReturn(new ExportChatInviteLink("42"));
        assertNull(this.botServiceImpl.onWebhookUpdateReceived(new Update()));
        verify(this.messageTypeHandler).getMessageType((Update) any());
        verify(this.botRequestService).document((Update) any());
    }

    @Test
    void testOnWebhookUpdateReceived5() {
        when(this.messageTypeHandler.getMessageType((Update) any())).thenReturn(MessageType.CALLBACK);
//        when(this.botRequestService.callback((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.document((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.phoneNumber((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.botCommand((Update) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botRequestService.plainText((Update) any())).thenReturn(new ExportChatInviteLink("42"));
        assertNull(this.botServiceImpl.onWebhookUpdateReceived(new Update()));
        verify(this.messageTypeHandler).getMessageType((Update) any());
        verify(this.botRequestService).callback((Update) any());
    }
}


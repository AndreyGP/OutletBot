package com.example.outletbot.bot.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.outletbot.bot.common.MessageType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.ChatJoinRequest;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

@ContextConfiguration(classes = {MessageTypeHandler.class})
@ExtendWith(SpringExtension.class)
class MessageTypeHandlerTest {
    @Autowired
    private MessageTypeHandler messageTypeHandler;

    @Test
    void testGetMessageType() {
        assertEquals(MessageType.OTHER, this.messageTypeHandler.getMessageType(new Update()));
    }

    @Test
    void testGetMessageType2() {
        Message message = new Message();
        InlineQuery inlineQuery = new InlineQuery();
        ChosenInlineQuery chosenInlineQuery = new ChosenInlineQuery();
        CallbackQuery callbackQuery = new CallbackQuery();
        Message editedMessage = new Message();
        Message channelPost = new Message();
        Message editedChannelPost = new Message();
        ShippingQuery shippingQuery = new ShippingQuery();
        PreCheckoutQuery preCheckoutQuery = new PreCheckoutQuery();
        Poll poll = new Poll();
        PollAnswer pollAnswer = new PollAnswer();
        ChatMemberUpdated myChatMember = new ChatMemberUpdated();
        ChatMemberUpdated chatMember = new ChatMemberUpdated();
        assertEquals(MessageType.CALLBACK,
                this.messageTypeHandler.getMessageType(new Update(123, message, inlineQuery, chosenInlineQuery, callbackQuery,
                        editedMessage, channelPost, editedChannelPost, shippingQuery, preCheckoutQuery, poll, pollAnswer,
                        myChatMember, chatMember, new ChatJoinRequest())));
    }
}


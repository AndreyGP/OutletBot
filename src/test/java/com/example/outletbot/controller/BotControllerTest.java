package com.example.outletbot.controller;

import com.example.outletbot.bot.WebHookOutletBot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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

@ContextConfiguration(classes = {BotController.class})
@ExtendWith(SpringExtension.class)
class BotControllerTest {
    @Autowired
    private BotController botController;

    @MockBean
    private WebHookOutletBot webHookOutletBot;

    @Test
    void testOnUpdateReceived() throws Exception {
        Update update = new Update();
        update.setChatMember(new ChatMemberUpdated());
        update.setMessage(new Message());
        update.setInlineQuery(new InlineQuery());
        update.setChatJoinRequest(new ChatJoinRequest());
        update.setPoll(new Poll());
        update.setUpdateId(123);
        update.setPollAnswer(new PollAnswer());
        update.setPreCheckoutQuery(new PreCheckoutQuery());
        update.setMyChatMember(new ChatMemberUpdated());
        update.setEditedChannelPost(new Message());
        update.setShippingQuery(new ShippingQuery());
        update.setEditedMessage(new Message());
        update.setCallbackQuery(new CallbackQuery());
        update.setChosenInlineQuery(new ChosenInlineQuery());
        update.setChannelPost(new Message());
        String content = (new ObjectMapper()).writeValueAsString(update);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.botController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}


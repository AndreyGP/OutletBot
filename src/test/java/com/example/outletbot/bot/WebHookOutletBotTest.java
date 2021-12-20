package com.example.outletbot.bot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.example.outletbot.bot.config.BotConfiguration;
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

import java.util.ArrayList;

import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.ChatJoinRequest;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Dice;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageAutoDeleteTimerChanged;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.ProximityAlertTriggered;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Venue;
import org.telegram.telegrambots.meta.api.objects.Video;
import org.telegram.telegrambots.meta.api.objects.VideoNote;
import org.telegram.telegrambots.meta.api.objects.Voice;
import org.telegram.telegrambots.meta.api.objects.games.Animation;
import org.telegram.telegrambots.meta.api.objects.games.Game;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.passport.PassportData;
import org.telegram.telegrambots.meta.api.objects.payments.Invoice;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;
import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatEnded;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatParticipantsInvited;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatScheduled;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatStarted;

class WebHookOutletBotTest {
    @Test
    void testConstructor() {
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BaseEmployeeService baseEmployeeService = new BaseEmployeeService(null, null, null);

        BotResponseService service = new BotResponseService(baseEmployeeService, new BotKeyboardReplyService());

        EmployeeCollationService collationService = new EmployeeCollationService(mock(EmployeeMongoRepository.class));
        BaseEmployee baseEmployee = new BaseEmployee();
        BotServiceImpl botService = new BotServiceImpl(typeHandler, new BotRequestService(commandTypeHandler, service,
                new BaseEmployeeService(collationService, baseEmployee, new EmployeeAlertService(null))));

        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        WebHookOutletBot actualWebHookOutletBot = new WebHookOutletBot(botService, botConfiguration);

        assertEquals("https://api.telegram.org/botnull/", actualWebHookOutletBot.getBaseUrl());
        assertEquals("Web Hook Path", actualWebHookOutletBot.getBotPath());
        DefaultBotOptions options = actualWebHookOutletBot.getOptions();
        assertEquals(1, options.getMaxThreads());
        HttpContext httpContext = options.getHttpContext();
        assertTrue(httpContext instanceof HttpClientContext);
        assertEquals(50, options.getGetUpdatesTimeout());
        assertEquals(100, options.getGetUpdatesLimit());
        SetWebhook setWebhook = actualWebHookOutletBot.getSetWebhook();
        assertNull(setWebhook.getIpAddress());
        assertNull(setWebhook.getMaxConnections());
        assertTrue(setWebhook.getAllowedUpdates().isEmpty());
        assertEquals("Web Hook Path", setWebhook.getUrl());
        assertEquals(DefaultBotOptions.ProxyType.NO_PROXY, options.getProxyType());
        assertNull(setWebhook.getCertificate());
        assertNull(setWebhook.getDropPendingUpdates());
        assertEquals("https://api.telegram.org/bot", options.getBaseUrl());
        assertNull(((HttpClientContext) httpContext).getRedirectLocations());
    }

    @Test
    void testGetBotUsername() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        assertNull((new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration)).getBotUsername());
    }

    @Test
    void testGetBotToken() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        assertNull((new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration)).getBotToken());
    }

    @Test
    void testOnWebhookUpdateReceived() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        WebHookOutletBot webHookOutletBot = new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration);
        assertNull(webHookOutletBot.onWebhookUpdateReceived(new Update()));
    }

    @Test
    void testOnWebhookUpdateReceived2() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        WebHookOutletBot webHookOutletBot = new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration);
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
        assertNull(webHookOutletBot.onWebhookUpdateReceived(new Update(123, message, inlineQuery, chosenInlineQuery,
                callbackQuery, editedMessage, channelPost, editedChannelPost, shippingQuery, preCheckoutQuery, poll, pollAnswer,
                myChatMember, chatMember, new ChatJoinRequest())));
    }

    @Test
    void testOnWebhookUpdateReceived3() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        WebHookOutletBot webHookOutletBot = new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration);

        Update update = new Update();
        update.setMessage(new Message());
        assertNull(webHookOutletBot.onWebhookUpdateReceived(update));
    }

    @Test
    void testOnWebhookUpdateReceived4() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        WebHookOutletBot webHookOutletBot = new WebHookOutletBot(
                new BotServiceImpl(typeHandler,
                        new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                botConfiguration);

        Update update = new Update();
        User from = new User();
        Chat chat = new Chat();
        User forwardFrom = new User();
        Chat forwardFromChat = new Chat();
        ArrayList<MessageEntity> entities = new ArrayList<MessageEntity>();
        ArrayList<MessageEntity> captionEntities = new ArrayList<MessageEntity>();
        Audio audio = new Audio();
        Document document = new Document();
        ArrayList<PhotoSize> photo = new ArrayList<PhotoSize>();
        Sticker sticker = new Sticker();
        Video video = new Video();
        Contact contact = new Contact();
        Location location = new Location();
        Venue venue = new Venue();
        Animation animation = new Animation();
        Message pinnedMessage = new Message();
        ArrayList<User> newChatMembers = new ArrayList<User>();
        User leftChatMember = new User();
        ArrayList<PhotoSize> newChatPhoto = new ArrayList<PhotoSize>();
        Message replyToMessage = new Message();
        Voice voice = new Voice();
        Game game = new Game();
        Invoice invoice = new Invoice();
        SuccessfulPayment successfulPayment = new SuccessfulPayment();
        VideoNote videoNote = new VideoNote();
        PassportData passportData = new PassportData();
        Poll poll = new Poll();
        InlineKeyboardMarkup replyMarkup = new InlineKeyboardMarkup();
        Dice dice = new Dice();
        User viaBot = new User();
        Chat senderChat = new Chat();
        ProximityAlertTriggered proximityAlertTriggered = new ProximityAlertTriggered();
        MessageAutoDeleteTimerChanged messageAutoDeleteTimerChanged = new MessageAutoDeleteTimerChanged();
        VoiceChatStarted voiceChatStarted = new VoiceChatStarted();
        VoiceChatEnded voiceChatEnded = new VoiceChatEnded();
        VoiceChatParticipantsInvited voiceChatParticipantsInvited = new VoiceChatParticipantsInvited();
        update.setMessage(new Message(123, from, 1, chat, forwardFrom, forwardFromChat, 1, "Text", entities,
                captionEntities, audio, document, photo, sticker, video, contact, location, venue, animation, pinnedMessage,
                newChatMembers, leftChatMember, "Dr", newChatPhoto, true, true, replyToMessage, voice, "Caption", true, true,
                123L, 123L, 1, game, 123, invoice, successfulPayment, videoNote, "JaneDoe", "Forward Signature", "42",
                "Connected Website", passportData, "Forward Sender Name", poll, replyMarkup, dice, viaBot, senderChat,
                proximityAlertTriggered, messageAutoDeleteTimerChanged, voiceChatStarted, voiceChatEnded,
                voiceChatParticipantsInvited, new VoiceChatScheduled(), true, true));
        assertNull(webHookOutletBot.onWebhookUpdateReceived(update));
    }

    @Test
    void testGetBotPath() {
        BotConfiguration botConfiguration = new BotConfiguration();
        botConfiguration.setWebHookPath("Web Hook Path");
        MessageTypeHandler typeHandler = new MessageTypeHandler();
        CommandTypeHandler commandTypeHandler = new CommandTypeHandler();
        BotResponseService service = new BotResponseService(null, null);

        assertEquals("Web Hook Path",
                (new WebHookOutletBot(
                        new BotServiceImpl(typeHandler,
                                new BotRequestService(commandTypeHandler, service, new BaseEmployeeService(null, null, null))),
                        botConfiguration)).getBotPath());
    }
}


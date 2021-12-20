package com.example.outletbot.bot.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.bot.common.BotCommandType;
import com.example.outletbot.bot.handler.CommandTypeHandler;
import com.example.outletbot.service.BaseEmployeeService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telegram.telegrambots.meta.api.methods.groupadministration.ExportChatInviteLink;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.Chat;
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
import org.telegram.telegrambots.meta.api.objects.passport.PassportData;
import org.telegram.telegrambots.meta.api.objects.payments.Invoice;
import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatEnded;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatParticipantsInvited;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatScheduled;
import org.telegram.telegrambots.meta.api.objects.voicechat.VoiceChatStarted;

@ContextConfiguration(classes = {BotRequestService.class})
@ExtendWith(SpringExtension.class)
class BotRequestServiceTest {
    @MockBean
    private BaseEmployeeService baseEmployeeService;

    @Autowired
    private BotRequestService botRequestService;

    @MockBean
    private BotResponseService botResponseService;

    @MockBean
    private CommandTypeHandler commandTypeHandler;

    @Test
    void testBotCommand() {
        when(this.commandTypeHandler.getCommandType((Update) any())).thenReturn(BotCommandType.HELP);
        assertNull(this.botRequestService.botCommand(new Update()));
        verify(this.commandTypeHandler).getCommandType((Update) any());
    }

    @Test
    void testBotCommand2() {
        when(this.commandTypeHandler.getCommandType((Update) any())).thenReturn(BotCommandType.START);
        ExportChatInviteLink exportChatInviteLink = new ExportChatInviteLink("42");
//        when(this.botResponseService.replyPhoneQuestion((String) any())).thenReturn(exportChatInviteLink);
        when(this.baseEmployeeService.isNewEmployee((String) any())).thenReturn(true);

        Update update = new Update();
        User from = new User();
        Chat chat = new Chat(123L, "Type");

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
        assertSame(exportChatInviteLink, this.botRequestService.botCommand(update));
        verify(this.commandTypeHandler).getCommandType((Update) any());
        verify(this.botResponseService).replyPhoneQuestion((String) any());
        verify(this.baseEmployeeService).isNewEmployee((String) any());
    }

    @Test
    void testBotCommand3() {
        when(this.commandTypeHandler.getCommandType((Update) any())).thenReturn(BotCommandType.START);
        ExportChatInviteLink exportChatInviteLink = new ExportChatInviteLink("42");
//        when(this.botResponseService.getMainMenuReply((String) any())).thenReturn(exportChatInviteLink);
//        when(this.botResponseService.replyPhoneQuestion((String) any())).thenReturn(new ExportChatInviteLink("42"));
        when(this.baseEmployeeService.containsInBD((String) any())).thenReturn(true);
        when(this.baseEmployeeService.isNewEmployee((String) any())).thenReturn(false);

        Update update = new Update();
        User from = new User();
        Chat chat = new Chat(123L, "Type");

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
        assertSame(exportChatInviteLink, this.botRequestService.botCommand(update));
        verify(this.commandTypeHandler).getCommandType((Update) any());
        verify(this.botResponseService).getMainMenuReply((String) any());
        verify(this.baseEmployeeService).containsInBD((String) any());
        verify(this.baseEmployeeService).isNewEmployee((String) any());
    }

    @Test
    void testBotCommand4() {
        when(this.commandTypeHandler.getCommandType((Update) any())).thenReturn(BotCommandType.START);
        ExportChatInviteLink exportChatInviteLink = new ExportChatInviteLink("42");
//        when(this.botResponseService.systemLaunch((String) any())).thenReturn(exportChatInviteLink);
//        when(this.botResponseService.getMainMenuReply((String) any())).thenReturn(new ExportChatInviteLink("42"));
//        when(this.botResponseService.replyPhoneQuestion((String) any())).thenReturn(new ExportChatInviteLink("42"));
        when(this.baseEmployeeService.isInitSystem((String) any())).thenReturn(true);
        when(this.baseEmployeeService.containsInBD((String) any())).thenReturn(false);
        when(this.baseEmployeeService.isNewEmployee((String) any())).thenReturn(false);

        Update update = new Update();
        User from = new User();
        Chat chat = new Chat(123L, "Type");

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
        assertSame(exportChatInviteLink, this.botRequestService.botCommand(update));
        verify(this.commandTypeHandler).getCommandType((Update) any());
        verify(this.botResponseService).systemLaunch((String) any());
        verify(this.baseEmployeeService).containsInBD((String) any());
        verify(this.baseEmployeeService).isInitSystem((String) any());
        verify(this.baseEmployeeService).isNewEmployee((String) any());
    }

    @Test
    void testPhoneNumber() {
        assertNull(this.botRequestService.phoneNumber(new Update()));
    }

    @Test
    void testPlainText() {
        assertNull(this.botRequestService.plainText(new Update()));
    }

    @Test
    void testDocument() {
        assertNull(this.botRequestService.document(new Update()));
    }

    @Test
    void testCallback() {
        assertNull(this.botRequestService.callback(new Update()));
    }

    @Test
    void testOther() {
        assertNull(this.botRequestService.other(new Update()));
    }
}


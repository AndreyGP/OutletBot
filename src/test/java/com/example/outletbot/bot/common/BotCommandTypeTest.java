package com.example.outletbot.bot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BotCommandTypeTest {
    @Test
    void testFromString() {
        assertEquals(BotCommandType.MAIN_MENU, BotCommandType.fromString("Command"));
        assertEquals(BotCommandType.MAIN_MENU, BotCommandType.fromString("foo"));
        assertEquals(BotCommandType.START, BotCommandType.fromString("/start"));
    }
}


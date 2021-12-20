package com.example.outletbot.bot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BotStateTest {
    @Test
    void testFromString() {
        assertEquals(BotState.MAIN_MENU_DEFAULT, BotState.fromString("Bot State"));
        assertEquals(BotState.MAIN_MENU_DEFAULT, BotState.fromString("foo"));
        assertEquals(BotState.START, BotState.fromString("start"));
    }
}


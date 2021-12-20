package com.example.outletbot.bot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MessageTypeTest {

    @Test
    void testValues() {
        MessageType[] actualValuesResult = MessageType.values();
        assertEquals(6, actualValuesResult.length);
        assertEquals(MessageType.PLAIN_TEXT, actualValuesResult[0]);
        assertEquals(MessageType.BOT_COMMAND, actualValuesResult[1]);
        assertEquals(MessageType.PHONE_NUMBER, actualValuesResult[2]);
        assertEquals(MessageType.DOCUMENT, actualValuesResult[3]);
        assertEquals(MessageType.CALLBACK, actualValuesResult[4]);
        assertEquals(MessageType.OTHER, actualValuesResult[5]);
    }
}


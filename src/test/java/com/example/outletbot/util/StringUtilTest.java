package com.example.outletbot.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringUtilTest {
    @Test
    void testTrim() {
        assertEquals("foo", StringUtil.trim("foo"));
        assertEquals("", StringUtil.trim(null));
        assertEquals("", StringUtil.trim(""));
    }

    @Test
    void testIsBlank() {
        assertFalse(StringUtil.isBlank("foo"));
        assertTrue(StringUtil.isBlank(null));
        assertTrue(StringUtil.isBlank(""));
    }

    @Test
    void testSerialize() {
        assertEquals("\"42\"", StringUtil.serialize("42"));
        assertEquals("0", StringUtil.serialize(0));
    }

    @Test
    void testDeserialize() {
        assertFalse(StringUtil.<Object>deserialize("Json", Object.class).isPresent());
        assertFalse(StringUtil.<Object>deserialize("foo", Object.class).isPresent());
        assertTrue(StringUtil.<Object>deserialize("42", Object.class).isPresent());
        assertFalse(StringUtil.<Object>deserialize("", Object.class).isPresent());
        assertFalse(StringUtil.<Object>deserialize("Json", null).isPresent());
    }
}


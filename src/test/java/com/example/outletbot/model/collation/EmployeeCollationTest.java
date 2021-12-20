package com.example.outletbot.model.collation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeCollationTest {
    @Test
    void testConstructor() {
        assertEquals("null\nРоль: null\nТел.: null\nОсновная точка: null\nTelegram: @null\n",
                (new EmployeeCollation()).toString());
    }
}


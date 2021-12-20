package com.example.outletbot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OrderStatusTest {
    @Test
    void testFromStringOriginal() {
        assertEquals(OrderStatus.SUSPENDED, OrderStatus.fromStringOriginal("Status Original"));
        assertEquals(OrderStatus.SUSPENDED, OrderStatus.fromStringOriginal("foo"));
        assertEquals(OrderStatus.SUSPENDED, OrderStatus.fromStringOriginal("suspended"));
    }

    @Test
    void testFromStringRu() {
        assertEquals(OrderStatus.SUSPENDED, OrderStatus.fromStringRu("Status Ru"));
        assertEquals(OrderStatus.SUSPENDED, OrderStatus.fromStringRu("suspended"));
    }
}


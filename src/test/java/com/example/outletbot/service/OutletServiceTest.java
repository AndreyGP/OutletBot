package com.example.outletbot.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OutletServiceTest {
    @Test
    void testConstructor() {
        assertTrue((new OutletService()).getAllOutlets().isEmpty());
    }
}


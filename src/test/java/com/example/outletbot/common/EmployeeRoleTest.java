package com.example.outletbot.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeRoleTest {
    @Test
    void testFromString() {
        assertEquals(EmployeeRole.NEW, EmployeeRole.fromString("Employee Role"));
        assertEquals(EmployeeRole.NEW, EmployeeRole.fromString("foo"));
        assertEquals(EmployeeRole.NEW, EmployeeRole.fromString("Новый"));
    }
}


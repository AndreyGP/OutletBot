package com.example.outletbot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.bot.common.BotState;
import com.example.outletbot.common.EmployeeRole;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

class BaseEmployeeTest {
    @Test
    void testGetNewEmployee() {
        BaseEmployee baseEmployee = new BaseEmployee();
        Message message = mock(Message.class);
        when(message.getFrom()).thenReturn(new User());
        when(message.getChatId()).thenReturn(123L);
        Employee actualNewEmployee = baseEmployee.getNewEmployee(message);
        assertNull(actualNewEmployee.getUsername());
        assertEquals(EmployeeRole.NEW, actualNewEmployee.getEmployeeRole());
        assertEquals("123", actualNewEmployee.getChatId());
        assertEquals(BotState.START, actualNewEmployee.getBotState());
        verify(message).getChatId();
        verify(message).getFrom();
    }

    @Test
    void testGetNewEmployee2() {
        BaseEmployee baseEmployee = new BaseEmployee();
        User user = mock(User.class);
        when(user.getUserName()).thenReturn("janedoe");
        Message message = mock(Message.class);
        when(message.getFrom()).thenReturn(user);
        when(message.getChatId()).thenReturn(123L);
        Employee actualNewEmployee = baseEmployee.getNewEmployee(message);
        assertEquals("janedoe", actualNewEmployee.getUsername());
        assertEquals(EmployeeRole.NEW, actualNewEmployee.getEmployeeRole());
        assertEquals("123", actualNewEmployee.getChatId());
        assertEquals(BotState.START, actualNewEmployee.getBotState());
        verify(message).getChatId();
        verify(message).getFrom();
        verify(user).getUserName();
    }
}


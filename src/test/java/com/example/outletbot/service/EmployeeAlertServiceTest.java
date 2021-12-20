package com.example.outletbot.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import com.example.outletbot.bot.service.BotAlertService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeAlertService.class})
@ExtendWith(SpringExtension.class)
class EmployeeAlertServiceTest {
    @MockBean
    private BotAlertService botAlertService;

    @Autowired
    private EmployeeAlertService employeeAlertService;

    @Test
    void testSendSimpleAlert() {
        doNothing().when(this.botAlertService).sendingMessage((String) any(), (String) any());
        this.employeeAlertService.sendSimpleAlert("42", "Not all who wander are lost");
        verify(this.botAlertService).sendingMessage((String) any(), (String) any());
    }
}


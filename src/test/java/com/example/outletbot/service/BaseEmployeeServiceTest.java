package com.example.outletbot.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.model.BaseEmployee;
import com.example.outletbot.model.collation.EmployeeCollation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BaseEmployeeService.class})
@ExtendWith(SpringExtension.class)
class BaseEmployeeServiceTest {
    @MockBean
    private BaseEmployee baseEmployee;

    @Autowired
    private BaseEmployeeService baseEmployeeService;

    @MockBean
    private EmployeeAlertService employeeAlertService;

    @MockBean
    private EmployeeCollationService employeeCollationService;

    @Test
    void testIsNewEmployee() {
        assertFalse(this.baseEmployeeService.isNewEmployee("42"));
    }

    @Test
    void testContainsInBD() {
        EmployeeCollation employeeCollation = new EmployeeCollation();
        employeeCollation.setLastName("Doe");
        employeeCollation.setCurrentOutlet("Current Outlet");
        employeeCollation.setEmployeeRole("Employee Role");
        employeeCollation.setFullName("Dr Jane Doe");
        employeeCollation.setChatId("42");
        employeeCollation.setUsername("janedoe");
        employeeCollation.setId("42");
        employeeCollation.setPhoneNumber("4105551212");
        employeeCollation.setBotState("Bot State");
        employeeCollation.setBaseOutlet("Base Outlet");
        employeeCollation.setFirstName("Jane");
        when(this.employeeCollationService.getEmployeeCollationByChatId((String) any())).thenReturn(employeeCollation);
        assertTrue(this.baseEmployeeService.containsInBD("42"));
        verify(this.employeeCollationService).getEmployeeCollationByChatId((String) any());
    }

    @Test
    void testIsInitSystem() {
        when(this.employeeCollationService.getCountEmployee()).thenReturn(3L);
        assertFalse(this.baseEmployeeService.isInitSystem("42"));
        verify(this.employeeCollationService).getCountEmployee();
    }

    @Test
    void testIsInitSystem2() {
        when(this.employeeCollationService.getCountEmployee()).thenReturn(0L);
        assertTrue(this.baseEmployeeService.isInitSystem("42"));
        verify(this.employeeCollationService).getCountEmployee();
    }
}


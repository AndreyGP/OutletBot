package com.example.outletbot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.model.collation.EmployeeCollation;
import com.example.outletbot.repository.EmployeeMongoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeCollationService.class})
@ExtendWith(SpringExtension.class)
class EmployeeCollationServiceTest {
    @Autowired
    private EmployeeCollationService employeeCollationService;

    @MockBean
    private EmployeeMongoRepository employeeMongoRepository;

    @Test
    void testGetCountEmployee() {
        when(this.employeeMongoRepository.count()).thenReturn(3L);
        assertEquals(3L, this.employeeCollationService.getCountEmployee());
        verify(this.employeeMongoRepository).count();
    }

    @Test
    void testGetEmployeeCollationByChatId() {
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
        when(this.employeeMongoRepository.findByChatId((String) any())).thenReturn(employeeCollation);
        assertSame(employeeCollation, this.employeeCollationService.getEmployeeCollationByChatId("42"));
        verify(this.employeeMongoRepository).findByChatId((String) any());
        assertEquals(0L, this.employeeCollationService.getCountEmployee());
    }

    @Test
    void testGetEmployeeCollationByPhoneNumber() {
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
        when(this.employeeMongoRepository.findByPhoneNumber((String) any())).thenReturn(employeeCollation);
        assertSame(employeeCollation, this.employeeCollationService.getEmployeeCollationByPhoneNumber("4105551212"));
        verify(this.employeeMongoRepository).findByPhoneNumber((String) any());
        assertEquals(0L, this.employeeCollationService.getCountEmployee());
    }

    @Test
    void testAddNewEmployeeCollation() {
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
        when(this.employeeMongoRepository.save((EmployeeCollation) any())).thenReturn(employeeCollation);

        EmployeeCollation employeeCollation1 = new EmployeeCollation();
        employeeCollation1.setLastName("Doe");
        employeeCollation1.setCurrentOutlet("Current Outlet");
        employeeCollation1.setEmployeeRole("Employee Role");
        employeeCollation1.setFullName("Dr Jane Doe");
        employeeCollation1.setChatId("42");
        employeeCollation1.setUsername("janedoe");
        employeeCollation1.setId("42");
        employeeCollation1.setPhoneNumber("4105551212");
        employeeCollation1.setBotState("Bot State");
        employeeCollation1.setBaseOutlet("Base Outlet");
        employeeCollation1.setFirstName("Jane");
        this.employeeCollationService.addNewEmployeeCollation(employeeCollation1);
        verify(this.employeeMongoRepository).save((EmployeeCollation) any());
        assertEquals(0L, this.employeeCollationService.getCountEmployee());
    }

    @Test
    void testDeleteEmployeeCollationByChatId() {
        doNothing().when(this.employeeMongoRepository).deleteByChatId((String) any());
        this.employeeCollationService.deleteEmployeeCollationByChatId("42");
        verify(this.employeeMongoRepository).deleteByChatId((String) any());
        assertEquals(0L, this.employeeCollationService.getCountEmployee());
    }

    @Test
    void testDeleteEmployeeCollationByPhoneNumber() {
        doNothing().when(this.employeeMongoRepository).deleteByPhoneNumber((String) any());
        this.employeeCollationService.deleteEmployeeCollationByPhoneNumber("4105551212");
        verify(this.employeeMongoRepository).deleteByPhoneNumber((String) any());
        assertEquals(0L, this.employeeCollationService.getCountEmployee());
    }
}


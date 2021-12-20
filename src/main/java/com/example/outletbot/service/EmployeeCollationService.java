package com.example.outletbot.service;

import com.example.outletbot.model.collation.EmployeeCollation;
import com.example.outletbot.repository.EmployeeMongoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeCollationService.java
 * Date/time: 20 декабрь 2021 in 0:59
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeCollationService {
    private final EmployeeMongoRepository mongoRepository;

    public long getCountEmployee() {
       return mongoRepository.count();
    }

    public EmployeeCollation getEmployeeCollationByChatId(String chatId) {
        return mongoRepository.findByChatId(chatId);
    }

    public EmployeeCollation getEmployeeCollationByPhoneNumber(String phoneNumber) {
        return mongoRepository.findByPhoneNumber(phoneNumber);
    }

    public void addNewEmployeeCollation(EmployeeCollation employeeCollation) {
        mongoRepository.save(employeeCollation);
    }

    public void deleteEmployeeCollationByChatId(String chatId) {
        mongoRepository.deleteByChatId(chatId);
    }

    public void deleteEmployeeCollationByPhoneNumber(String phoneNumber) {
        mongoRepository.deleteByPhoneNumber(phoneNumber);
    }


}

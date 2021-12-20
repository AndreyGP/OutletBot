package com.example.outletbot.repository;

import com.example.outletbot.model.collation.EmployeeCollation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeMongoRepository.java
 * Date/time: 20 декабрь 2021 in 0:23
 */
@Repository
public interface EmployeeMongoRepository extends MongoRepository<EmployeeCollation, String> {
    EmployeeCollation findByChatId(String chatId);
    EmployeeCollation findByPhoneNumber(String phoneNumber);
    void deleteByChatId(String chatId);
    void deleteByPhoneNumber(String phoneNumber);
}

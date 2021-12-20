package com.example.outletbot.repository;

import com.example.outletbot.model.collation.OutletCollation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OutletMongoRepository.java
 * Date/time: 20 декабрь 2021 in 0:24
 */
@Repository
public interface OutletMongoRepository extends MongoRepository<OutletCollation, String> {
    List<OutletCollation> findAllBySupervisorId(String supervisorId);
    OutletCollation findByOutletNumber(String outletNumber);
    void deleteByOutletNumber(String outletNumber);
}

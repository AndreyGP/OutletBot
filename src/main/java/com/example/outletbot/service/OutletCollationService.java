package com.example.outletbot.service;

import com.example.outletbot.model.collation.OutletCollation;
import com.example.outletbot.repository.OutletMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OutletCollationService.java
 * Date/time: 20 декабрь 2021 in 1:27
 */
@Service
public class OutletCollationService {
    OutletMongoRepository mongoRepository;

    public OutletCollationService(OutletMongoRepository repository) {
        mongoRepository = repository;
    }

    public List<OutletCollation> findAllBySupervisorId(String supervisorId) {
        return mongoRepository.findAllBySupervisorId(supervisorId);
    }

    public OutletCollation findByOutletNumber(String outletNumber) {
        return mongoRepository.findByOutletNumber(outletNumber);
    }

    public void addNewOutlet(OutletCollation outletCollation) {
        mongoRepository.save(outletCollation);
    }

    public void deleteByOutletNumber(String outletNumber) {
        mongoRepository.deleteByOutletNumber(outletNumber);
    }
}

package com.example.outletbot.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.outletbot.model.collation.OutletCollation;
import com.example.outletbot.repository.OutletMongoRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OutletCollationService.class})
@ExtendWith(SpringExtension.class)
class OutletCollationServiceTest {
    @Autowired
    private OutletCollationService outletCollationService;

    @MockBean
    private OutletMongoRepository outletMongoRepository;

    @Test
    void testFindAllBySupervisorId() {
        ArrayList<OutletCollation> outletCollationList = new ArrayList<OutletCollation>();
        when(this.outletMongoRepository.findAllBySupervisorId((String) any())).thenReturn(outletCollationList);
        List<OutletCollation> actualFindAllBySupervisorIdResult = this.outletCollationService.findAllBySupervisorId("42");
        assertSame(outletCollationList, actualFindAllBySupervisorIdResult);
        assertTrue(actualFindAllBySupervisorIdResult.isEmpty());
        verify(this.outletMongoRepository).findAllBySupervisorId((String) any());
    }

    @Test
    void testFindByOutletNumber() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");
        when(this.outletMongoRepository.findByOutletNumber((String) any())).thenReturn(outletCollation);
        assertSame(outletCollation, this.outletCollationService.findByOutletNumber("42"));
        verify(this.outletMongoRepository).findByOutletNumber((String) any());
    }

    @Test
    void testAddNewOutlet() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");
        when(this.outletMongoRepository.save((OutletCollation) any())).thenReturn(outletCollation);

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        this.outletCollationService.addNewOutlet(outletCollation1);
        verify(this.outletMongoRepository).save((OutletCollation) any());
    }

    @Test
    void testDeleteByOutletNumber() {
        doNothing().when(this.outletMongoRepository).deleteByOutletNumber((String) any());
        this.outletCollationService.deleteByOutletNumber("42");
        verify(this.outletMongoRepository).deleteByOutletNumber((String) any());
    }
}


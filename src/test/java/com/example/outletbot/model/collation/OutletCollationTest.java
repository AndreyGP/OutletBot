package com.example.outletbot.model.collation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OutletCollationTest {
    @Test
    void testCanEqual() {
        assertFalse((new OutletCollation()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        OutletCollation outletCollation = new OutletCollation();

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertTrue(outletCollation.canEqual(outletCollation1));
    }

    @Test
    void testConstructor() {
        OutletCollation actualOutletCollation = new OutletCollation();
        actualOutletCollation.setId("42");
        actualOutletCollation.setOutletNumber("42");
        actualOutletCollation.setSupervisorId("42");
        assertEquals("42", actualOutletCollation.getId());
        assertEquals("42", actualOutletCollation.getOutletNumber());
        assertEquals("42", actualOutletCollation.getSupervisorId());
        assertEquals("OutletCollation(id=42, outletNumber=42, supervisorId=42)", actualOutletCollation.toString());
    }

    @Test
    void testEquals() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");
        assertFalse(outletCollation.equals(null));
    }

    @Test
    void testEquals2() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");
        assertFalse(outletCollation.equals("Different type to OutletCollation"));
    }

    @Test
    void testEquals3() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");
        assertTrue(outletCollation.equals(outletCollation));
        int expectedHashCodeResult = outletCollation.hashCode();
        assertEquals(expectedHashCodeResult, outletCollation.hashCode());
    }

    @Test
    void testEquals4() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertTrue(outletCollation.equals(outletCollation1));
        int expectedHashCodeResult = outletCollation.hashCode();
        assertEquals(expectedHashCodeResult, outletCollation1.hashCode());
    }

    @Test
    void testEquals5() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber(null);
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals6() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("Outlet Number");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals7() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId(null);
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals8() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("Supervisor Id");
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals9() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId(null);

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals10() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId("Id");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertFalse(outletCollation.equals(outletCollation1));
    }

    @Test
    void testEquals11() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber(null);
        outletCollation.setSupervisorId("42");
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber(null);
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId("42");
        assertTrue(outletCollation.equals(outletCollation1));
        int expectedHashCodeResult = outletCollation.hashCode();
        assertEquals(expectedHashCodeResult, outletCollation1.hashCode());
    }

    @Test
    void testEquals12() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId(null);
        outletCollation.setId("42");

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId(null);
        outletCollation1.setId("42");
        assertTrue(outletCollation.equals(outletCollation1));
        int expectedHashCodeResult = outletCollation.hashCode();
        assertEquals(expectedHashCodeResult, outletCollation1.hashCode());
    }

    @Test
    void testEquals13() {
        OutletCollation outletCollation = new OutletCollation();
        outletCollation.setOutletNumber("42");
        outletCollation.setSupervisorId("42");
        outletCollation.setId(null);

        OutletCollation outletCollation1 = new OutletCollation();
        outletCollation1.setOutletNumber("42");
        outletCollation1.setSupervisorId("42");
        outletCollation1.setId(null);
        assertTrue(outletCollation.equals(outletCollation1));
        int expectedHashCodeResult = outletCollation.hashCode();
        assertEquals(expectedHashCodeResult, outletCollation1.hashCode());
    }
}


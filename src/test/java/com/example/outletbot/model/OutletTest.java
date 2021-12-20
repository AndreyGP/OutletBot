package com.example.outletbot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Outlet.class})
@ExtendWith(SpringExtension.class)
class OutletTest {
    @Autowired
    private Outlet outlet;

    @Test
    void testCanEqual() {
        assertFalse(this.outlet.canEqual("Other"));
        assertTrue(this.outlet.canEqual(this.outlet));
    }

    @Test
    void testConstructor() {
        Outlet actualOutlet = new Outlet();
        HashMap<String, Employee> stringEmployeeMap = new HashMap<String, Employee>(1);
        actualOutlet.setCouriers(stringEmployeeMap);
        HashMap<String, Order> stringOrderMap = new HashMap<String, Order>(1);
        actualOutlet.setOrders(stringOrderMap);
        actualOutlet.setOutletNumber("42");
        HashMap<String, Employee> stringEmployeeMap1 = new HashMap<String, Employee>(1);
        actualOutlet.setPickers(stringEmployeeMap1);
        HashMap<String, Employee> stringEmployeeMap2 = new HashMap<String, Employee>(1);
        actualOutlet.setSeniors(stringEmployeeMap2);
        BaseEmployee baseEmployee = new BaseEmployee();
        actualOutlet.setSupervisor(baseEmployee);
        assertSame(stringEmployeeMap, actualOutlet.getCouriers());
        assertSame(stringOrderMap, actualOutlet.getOrders());
        assertEquals("42", actualOutlet.getOutletNumber());
        assertSame(stringEmployeeMap1, actualOutlet.getPickers());
        assertSame(stringEmployeeMap2, actualOutlet.getSeniors());
        assertSame(baseEmployee, actualOutlet.getSupervisor());
        assertEquals(
                "Outlet(outletNumber=42, supervisor=Employee(employeeRole=null, botState=null, chatId=null, phoneNumber=null,"
                        + " username=null, fullName=null, firstName=null, lastName=null, baseOutlet=null, currentOutlet=null),"
                        + " seniors={}, pickers={}, couriers={}, orders={})",
                actualOutlet.toString());
    }

    @Test
    void testEquals() {
        assertFalse((new Outlet()).equals(null));
        assertFalse((new Outlet()).equals("Different type to Outlet"));
        assertFalse((new Outlet()).equals(null));
    }

    @Test
    void testEquals2() {
        Outlet outlet = new Outlet();
        assertTrue(outlet.equals(outlet));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet.hashCode());
    }

    @Test
    void testEquals3() {
        Outlet outlet = new Outlet();
        Outlet outlet1 = new Outlet();
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals4() {
        Outlet outlet = new Outlet();
        outlet.setOutletNumber("42");
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals5() {
        Outlet outlet = new Outlet();
        outlet.setSeniors(null);
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals6() {
        Outlet outlet = new Outlet();
        outlet.setPickers(null);
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals7() {
        Outlet outlet = new Outlet();
        outlet.setOrders(null);
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals8() {
        Outlet outlet = new Outlet();
        outlet.setCouriers(null);
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals9() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setOutletNumber("42");
        assertFalse(outlet.equals(outlet1));
    }

    @Test
    void testEquals10() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setSeniors(null);
        assertFalse(outlet.equals(outlet1));
    }

    @Test
    void testEquals11() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setPickers(null);
        assertFalse(outlet.equals(outlet1));
    }

    @Test
    void testEquals12() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setOrders(null);
        assertFalse(outlet.equals(outlet1));
    }

    @Test
    void testEquals13() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setCouriers(null);
        assertFalse(outlet.equals(outlet1));
    }

    @Test
    void testEquals14() {
        Outlet outlet = new Outlet();
        outlet.setOutletNumber("42");

        Outlet outlet1 = new Outlet();
        outlet1.setOutletNumber("42");
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals15() {
        Outlet outlet = new Outlet();
        outlet.setSeniors(null);

        Outlet outlet1 = new Outlet();
        outlet1.setSeniors(null);
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals16() {
        Outlet outlet = new Outlet();
        outlet.setPickers(null);

        Outlet outlet1 = new Outlet();
        outlet1.setPickers(null);
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals17() {
        Outlet outlet = new Outlet();
        outlet.setOrders(null);

        Outlet outlet1 = new Outlet();
        outlet1.setOrders(null);
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals18() {
        Outlet outlet = new Outlet();
        outlet.setCouriers(null);

        Outlet outlet1 = new Outlet();
        outlet1.setCouriers(null);
        assertTrue(outlet.equals(outlet1));
        int expectedHashCodeResult = outlet.hashCode();
        assertEquals(expectedHashCodeResult, outlet1.hashCode());
    }

    @Test
    void testEquals19() {
        Outlet outlet = new Outlet();
        outlet.setSupervisor(new BaseEmployee());
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals20() {
        Outlet outlet = new Outlet();
        outlet.setSupervisor(mock(Employee.class));
        assertFalse(outlet.equals(new Outlet()));
    }

    @Test
    void testEquals21() {
        Outlet outlet = new Outlet();

        Outlet outlet1 = new Outlet();
        outlet1.setSupervisor(new BaseEmployee());
        assertFalse(outlet.equals(outlet1));
    }
}


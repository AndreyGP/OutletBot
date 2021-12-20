package com.example.outletbot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.outletbot.common.OrderStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Order.class})
@ExtendWith(SpringExtension.class)
class OrderTest {
    @Autowired
    private Order order;

    @Test
    void testCanEqual() {
        assertFalse(this.order.canEqual("Other"));
        assertTrue(this.order.canEqual(this.order));
    }

    @Test
    void testConstructor() {
        Order actualOrder = new Order();
        actualOrder.setAddress("42 Main St");
        actualOrder.setComment("Comment");
        actualOrder.setCourierAppointed(true);
        actualOrder.setCurrentStatus(OrderStatus.SUSPENDED);
        actualOrder.setDelayedDelivery(true);
        actualOrder.setDeliveryInterval("Delivery Interval");
        actualOrder.setDeliveryNumber("42");
        actualOrder.setEndDeliveryTime("End Delivery Time");
        actualOrder.setEndPickingTime("End Picking Time");
        actualOrder.setGrade(1);
        actualOrder.setOrderCourierName("Order Courier Name");
        actualOrder.setOrderPickerName("Order Picker Name");
        actualOrder.setPickUpTime("Pick Up Time");
        actualOrder.setQuantityOfPositions(1);
        actualOrder.setStartDeliveryTime("Start Delivery Time");
        assertEquals("42 Main St", actualOrder.getAddress());
        assertEquals("Comment", actualOrder.getComment());
        assertEquals(OrderStatus.SUSPENDED, actualOrder.getCurrentStatus());
        assertEquals("Delivery Interval", actualOrder.getDeliveryInterval());
        assertEquals("42", actualOrder.getDeliveryNumber());
        assertEquals("End Delivery Time", actualOrder.getEndDeliveryTime());
        assertEquals("End Picking Time", actualOrder.getEndPickingTime());
        assertEquals(1, actualOrder.getGrade());
        assertEquals("Order Courier Name", actualOrder.getOrderCourierName());
        assertEquals("Order Picker Name", actualOrder.getOrderPickerName());
        assertEquals("Pick Up Time", actualOrder.getPickUpTime());
        assertEquals(1, actualOrder.getQuantityOfPositions());
        assertEquals("Start Delivery Time", actualOrder.getStartDeliveryTime());
        assertTrue(actualOrder.isCourierAppointed());
        assertTrue(actualOrder.isDelayedDelivery());
        assertEquals("Order(currentStatus=SUSPENDED, deliveryNumber=42, address=42 Main St, deliveryInterval=Delivery"
                + " Interval, orderPickerName=Order Picker Name, orderCourierName=Order Courier Name, pickUpTime=Pick"
                + " Up Time, endPickingTime=End Picking Time, startDeliveryTime=Start Delivery Time, endDeliveryTime=End"
                + " Delivery Time, comment=Comment, grade=1, quantityOfPositions=1, delayedDelivery=true, courierAppointed"
                + "=true)", actualOrder.toString());
    }

    @Test
    void testEquals() {
        assertFalse((new Order()).equals(null));
        assertFalse((new Order()).equals("Different type to Order"));
        assertFalse((new Order()).equals(null));
    }

    @Test
    void testEquals2() {
        Order order = new Order();
        assertTrue(order.equals(order));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order.hashCode());
    }

    @Test
    void testEquals3() {
        Order order = new Order();
        Order order1 = new Order();
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals4() {
        Order order = new Order();
        order.setDelayedDelivery(true);
        assertFalse(order.equals(new Order()));
    }

    @Test
    void testEquals5() {
        Order order = new Order();
        order.setCourierAppointed(true);
        assertFalse(order.equals(new Order()));
    }

    @Test
    void testEquals6() {
        Order order = new Order();
        order.setAddress("42 Main St");
        assertFalse(order.equals(new Order()));
    }

    @Test
    void testEquals7() {
        Order order = new Order();
        order.setDeliveryNumber("42");
        assertFalse(order.equals(new Order()));
    }

    @Test
    void testEquals8() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals9() {
        Order order = new Order();

        Order order1 = new Order();
        order1.setDeliveryNumber("42");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals10() {
        Order order = new Order();
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals11() {
        Order order = new Order();
        order.setDeliveryNumber("42");

        Order order1 = new Order();
        order1.setDeliveryNumber("42");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals12() {
        Order order = new Order();
        order.setDeliveryInterval("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals13() {
        Order order = new Order();
        order.setPickUpTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals14() {
        Order order = new Order();
        order.setEndPickingTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals15() {
        Order order = new Order();
        order.setOrderPickerName("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals16() {
        Order order = new Order();
        order.setEndDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals17() {
        Order order = new Order();
        order.setStartDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals18() {
        Order order = new Order();
        order.setOrderCourierName("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals19() {
        Order order = new Order();
        order.setComment("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals20() {
        Order order = new Order();
        order.setDeliveryInterval("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setDeliveryInterval("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals21() {
        Order order = new Order();
        order.setPickUpTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setDeliveryInterval("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals22() {
        Order order = new Order();
        order.setPickUpTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setPickUpTime("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals23() {
        Order order = new Order();
        order.setPickUpTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setOrderPickerName("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals24() {
        Order order = new Order();
        order.setPickUpTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setOrderCourierName("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals25() {
        Order order = new Order();
        order.setEndPickingTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setPickUpTime("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals26() {
        Order order = new Order();
        order.setEndPickingTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setEndPickingTime("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals27() {
        Order order = new Order();
        order.setOrderPickerName("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setOrderPickerName("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals28() {
        Order order = new Order();
        order.setEndDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setEndPickingTime("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals29() {
        Order order = new Order();
        order.setEndDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setEndDeliveryTime("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals30() {
        Order order = new Order();
        order.setEndDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setStartDeliveryTime("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals31() {
        Order order = new Order();
        order.setStartDeliveryTime("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setStartDeliveryTime("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals32() {
        Order order = new Order();
        order.setOrderCourierName("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setOrderCourierName("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }

    @Test
    void testEquals33() {
        Order order = new Order();
        order.setComment("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setEndDeliveryTime("42 Main St");
        order1.setAddress("42 Main St");
        assertFalse(order.equals(order1));
    }

    @Test
    void testEquals34() {
        Order order = new Order();
        order.setComment("42 Main St");
        order.setAddress("42 Main St");

        Order order1 = new Order();
        order1.setComment("42 Main St");
        order1.setAddress("42 Main St");
        assertTrue(order.equals(order1));
        int expectedHashCodeResult = order.hashCode();
        assertEquals(expectedHashCodeResult, order1.hashCode());
    }
}


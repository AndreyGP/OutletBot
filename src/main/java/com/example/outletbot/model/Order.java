package com.example.outletbot.model;

import com.example.outletbot.common.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: Order.java
 * Date/time: 19 декабрь 2021 in 7:13
 */
@Slf4j
@Data
@EqualsAndHashCode
@ToString
@Component
public class Order {
    private OrderStatus currentStatus;
    private String deliveryNumber;
    private String address;
    private String deliveryInterval;
    private String orderPickerName;
    private String orderCourierName;
    private String pickUpTime;
    private String endPickingTime;
    private String startDeliveryTime;
    private String endDeliveryTime;
    private String comment;
    private int grade;
    private int quantityOfPositions;
    private boolean delayedDelivery;
    private boolean courierAppointed;
}

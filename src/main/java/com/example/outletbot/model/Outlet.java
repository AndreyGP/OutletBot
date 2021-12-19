package com.example.outletbot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: Outlet.java
 * Date/time: 19 декабрь 2021 in 6:14
 */
@Slf4j
@Data
@EqualsAndHashCode
@ToString
@Component
public class Outlet {
    private String outletNumber;
    private Employee supervisor;
    private Map<String, Employee> seniors = new ConcurrentHashMap<>();
    private Map<String, Employee> pickers = new ConcurrentHashMap<>();
    private Map<String, Employee> couriers = new ConcurrentHashMap<>();
    private Map<String, Order> orders = new ConcurrentHashMap<>();
}

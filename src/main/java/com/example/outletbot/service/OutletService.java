package com.example.outletbot.service;

import com.example.outletbot.model.Outlet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OutletService.java
 * Date/time: 19 декабрь 2021 in 6:14
 */
@Slf4j
@Service
@Getter
public class OutletService {
    private final Map<String, Outlet> allOutlets = new HashMap<>();
}

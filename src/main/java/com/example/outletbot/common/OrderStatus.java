package com.example.outletbot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OrderStatus.java
 * Date/time: 19 декабрь 2021 in 7:15
 */
@Getter
@Component
@AllArgsConstructor
public enum OrderStatus {
    SUSPENDED("Прогноз", "suspended"),
    CANSELED("Отменён", "canceled"),
    PAUSED("Приостановлен", "paused"),
    CAPTUDED("Подвешен", "doubled"),
    READY("Не взят", "ready"),
    COLLECTING("В сборке", "collecting"),
    ON_APPROVAL("Согласование", "on_approval"),
    ON_CASH_DESK("На кассе", "on_cash_desk"),
    PACKAGING("Пакуется", "packaging"),
    READY_TO_SHIP("На базе", "ready_to_ship"),
    SHIPPING("Доставка", "shipping"),
    SHIPPED("Доставлен", "shipped");

    private final String statusRu;
    private final String statusOriginal;
}

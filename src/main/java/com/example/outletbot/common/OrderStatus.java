package com.example.outletbot.common;

import com.example.outletbot.bot.common.BotState;
import lombok.Getter;

import java.util.Arrays;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OrderStatus.java
 * Date/time: 19 декабрь 2021 in 7:15
 */
@Getter
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

    OrderStatus(String statusRu, String statusOriginal) {
        this.statusRu = statusRu;
        this.statusOriginal = statusOriginal;
    }

    public static OrderStatus fromStringOriginal(String statusOriginal) {
        return Arrays.stream(OrderStatus.values())
                .filter(t -> t.getStatusOriginal().equals(statusOriginal))
                .findFirst()
                .orElse(SUSPENDED);
    }

    public static OrderStatus fromStringRu(String statusRu) {
        return Arrays.stream(OrderStatus.values())
                .filter(t -> t.getStatusOriginal().equals(statusRu))
                .findFirst()
                .orElse(SUSPENDED);
    }
}

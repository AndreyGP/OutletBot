package com.example.outletbot.bot.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: MessageType.java
 * Date/time: 19 декабрь 2021 in 3:27
 */
@Getter
@Component
@RequiredArgsConstructor
public enum MessageType {
    PLAIN_TEXT,
    BOT_COMMAND,
    PHONE_NUMBER,
    DOCUMENT,
    CALLBACK,
    OTHER
}

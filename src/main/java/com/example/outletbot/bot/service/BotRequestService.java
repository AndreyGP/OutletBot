package com.example.outletbot.bot.service;

import com.example.outletbot.bot.common.BotState;
import com.example.outletbot.bot.handler.CommandTypeHandler;
import com.example.outletbot.common.EmployeeRole;
import com.example.outletbot.model.collation.EmployeeCollation;
import com.example.outletbot.service.BaseEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: BotResponseService.java
 * Date/time: 19 декабрь 2021 in 3:53
 */
@Slf4j
@Service
//@AllArgsConstructor
public class BotRequestService {
    private final CommandTypeHandler commandTypeHandler;
    private final BotResponseService service;
    private final BaseEmployeeService baseEmployeeService;

    @Autowired
    public BotRequestService(CommandTypeHandler commandTypeHandler, BotResponseService service, BaseEmployeeService baseEmployeeService) {
        this.commandTypeHandler = commandTypeHandler;
        this.service = service;
        this.baseEmployeeService = baseEmployeeService;
    }


    public BotApiMethod<?> botCommand(Update update) {
        switch (commandTypeHandler.getCommandType(update)) {
            case START:
                return startBotCommandContext(update);
            case HELP:
            case MAIN_MENU:
            case FEEDBACK:
            case CLEAR:
            case CLEAR_ALL:
            default:
        }
        return null;
    }

    public BotApiMethod<?> phoneNumber(Update update) {
        return null;
    }

    public BotApiMethod<?> plainText(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        EmployeeCollation employeeCollation;
        if ((employeeCollation = baseEmployeeService.getEmployeeCollationByChatId(chatId)) != null) {
            return plainTextContext(employeeCollation, update);
        }
        return service.youNotFound(chatId);
    }

    public BotApiMethod<?> document(Update update) {
        return null;
    }

    public BotApiMethod<?> callback(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        EmployeeCollation employeeCollation;
        if ((employeeCollation = baseEmployeeService.getEmployeeCollationByChatId(chatId)) != null) {
            return callbackBotCommandContext(employeeCollation, update);
        }
        return service.youNotFound(chatId);
    }

    public BotApiMethod<?> other(Update update) {
        return null;
    }

    //        return service.replyPhoneQuestion(chatId); Success
    //        return service.getMainMenuReply(chatId); Success
    //        return service.systemLaunch(chatId); Success
    //        return service.getHelloMessage(chatId); Success
    private BotApiMethod<?> startBotCommandContext(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        if (baseEmployeeService.isNewEmployee(chatId)) {
            return service.replyPhoneQuestion(chatId);

        } else if (baseEmployeeService.containsInBD(chatId)) {
            return service.getMainMenuReply(chatId, false);

        } else if (baseEmployeeService.isInitSystem(chatId)) {
            return service.systemLaunch(chatId);
        }

        return service.getHelloMessage(chatId);
    }

    private BotApiMethod<?> callbackBotCommandContext(EmployeeCollation collation, Update update) {
        if (EmployeeRole.fromString(collation.getEmployeeRole()) == EmployeeRole.DEV) {
            return superuserCallbackContext(update);
        }
        return null;
    }

    private BotApiMethod<?> superuserCallbackContext(Update update) {
        String chatId = update.getCallbackQuery().getFrom().getId().toString();

        switch (BotState.fromString(update.getCallbackQuery().getData())) {
            case ADD_SUPER:
                return service.replyFullNameSuper(chatId);
            case FULL_NAME_SUPER_REGISTRATION:
            case PHONE_SUPER_REGISTRATION:
            case SUPER_REGISTRATION_SUCCESS:
            case DEV_DEBUG:
                return service.getDebugInfo(chatId);
            case MAIN_MENU_DEFAULT:
                return service.getMainMenuReply(chatId, true);
            case DEV_MANE_MENU:
            default:
                return service.getInlineSuperuserMainMenu(chatId);
        }
    }


    private BotApiMethod<?> plainTextContext(EmployeeCollation collation, Update update) {
        if (EmployeeRole.fromString(collation.getEmployeeRole()) == EmployeeRole.DEV) {
            return superuserPlainTextContext(collation, update);
        }
        return null;
    }

    private BotApiMethod<?> superuserPlainTextContext(EmployeeCollation collation, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        if (BotState.fromString(collation.getBotState()) == BotState.ADD_SUPER) {
            baseEmployeeService.addNewEmployee(update);
            return service.replyPhoneSupervisor(chatId);
        }
        return null;
    }
}

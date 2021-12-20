package com.example.outletbot.model.collation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: EmployeeCollation.java
 * Date/time: 19 декабрь 2021 in 23:50
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collation = "employee_profile_data")
public class EmployeeCollation implements Serializable {
    @Id
    String id;
    String employeeRole;
    String botState;
    String chatId;
    String phoneNumber;
    String username;
    String fullName;
    String firstName;
    String lastName;
    String baseOutlet;
    String currentOutlet;

    @Override
    public String toString() {
        return String.format(
                "%s%nРоль: %s%nТел.: %s%nОсновная точка: %s%nTelegram: %s%n",
                fullName, employeeRole, phoneNumber, baseOutlet, "@"+username
        );
    }
}

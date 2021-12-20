package com.example.outletbot.model.collation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * OutletBot Created by Home Work Studio AndrHey [andreigp]
 * FileName: OutletCollation.java
 * Date/time: 20 декабрь 2021 in 0:15
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collation = "outlet_profile_data")
public class OutletCollation {
    @Id
    String id;
    String outletNumber;
    String supervisorId;

}

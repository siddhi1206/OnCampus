package com.oncampus.model;

import com.oncampus.enums.CalendarCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "calendar_entries")
public class CalendarEntry {

    @Id
    private String id;

    private String title;

    private String description;

    private CalendarCategory category;

    private LocalDate startDate;

    private LocalDate endDate;

    private String createdBy;


}
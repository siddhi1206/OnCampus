package com.oncampus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "events")
@Data
public class Event {

    @Id
    private String id;

    private String title;

    private String description;

    private String category;

    private LocalDate eventDate;

    private LocalDate registrationDeadline;

    private String registrationLink;

    private String organizer;

}   
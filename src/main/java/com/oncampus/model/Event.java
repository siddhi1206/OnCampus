package com.oncampus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String title;

    private String description;

    private String type;
    // workshop, hackathon, seminar, placement

    private String date;

    private String educatorId; // link to User

}
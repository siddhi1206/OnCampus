package com.oncampus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
public class Task {

    @Id
    private String id;

    private String rollNo;

    private String title;

    private boolean completed;

}
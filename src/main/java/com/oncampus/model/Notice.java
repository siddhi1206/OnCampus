package com.oncampus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notices")
public class Notice {

    @Id
    private String id;

    private String title;

    private String content;

    private String category;

    private String educatorId;
}
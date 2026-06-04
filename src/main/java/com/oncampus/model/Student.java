package com.oncampus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student extends User {

    private String branch;

    private Integer year;

    private String rollNo;

    private List<String> savedEvents = new ArrayList<>();
    private List<String> taskIds = new ArrayList<>();
}

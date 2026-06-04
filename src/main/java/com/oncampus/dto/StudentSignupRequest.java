package com.oncampus.dto;

import lombok.Data;

@Data
public class StudentSignupRequest {

    private String name;
    private String email;
    private String password;

    private String branch;
    private Integer year;
    private String rollNo;
}
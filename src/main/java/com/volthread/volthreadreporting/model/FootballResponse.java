package com.volthread.volthreadreporting.model;

import com.volthread.volthreadreporting.entity.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class FootballResponse {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private Date birthDate;
    private String fanOf;
    private String explanation;
    private String pollsterName;
    private String pollsterSurname;
}

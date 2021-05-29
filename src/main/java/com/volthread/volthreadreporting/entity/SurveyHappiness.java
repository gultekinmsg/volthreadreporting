package com.volthread.volthreadreporting.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class SurveyHappiness {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer happiness;
    private String mostHappy;
    private String mostUnHappy;
    private String explanation;
    private String pollsterName;
    private String pollsterSurname;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
}

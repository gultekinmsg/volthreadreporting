package com.volthread.volthreadreporting.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Particapator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @OneToMany
    @JoinColumn(name = "surveyfootball_id")
    private List<SurveyFootball> surveyFootball;
    @OneToMany
    @JoinColumn(name = "surveyhappiness_id")
    private List<SurveyHappiness> surveyHappiness;
}

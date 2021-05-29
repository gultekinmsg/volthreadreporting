package com.volthread.volthreadreporting.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Pollster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String pollsterName;
    private String pollsterSurname;
    @OneToMany
    @JoinColumn(name = "surveyfootball_id")
    private List<SurveyFootball> surveyFootball;
    @OneToMany
    @JoinColumn(name = "surveyhappiness_id")
    private List<SurveyHappiness> surveyHappiness;
}

package com.volthread.volthreadreporting.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "pollster_id")
    private Pollster pollster;
    @ManyToOne
    @JoinColumn(name = "particapator_id")
    private Particapator particapator;
}

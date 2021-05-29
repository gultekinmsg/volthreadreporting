package com.volthread.volthreadreporting.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class StatisticResponse {
    private Double happinessRate;
    private HashMap<String, Integer> teamRatio;
}

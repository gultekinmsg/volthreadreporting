package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.model.StatisticResponse;
import com.volthread.volthreadreporting.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/statistics")
    public StatisticResponse getStatistic() {
        return statisticService.getStatistics();
    }
}

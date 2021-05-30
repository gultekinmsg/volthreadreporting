package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.model.StatisticResponse;
import com.volthread.volthreadreporting.repository.SurveyFootballRepository;
import com.volthread.volthreadreporting.repository.SurveyHappinessRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class StatisticServiceTest {
    @MockBean
    private SurveyFootballRepository surveyFootballRepository;
    @MockBean
    private SurveyHappinessRepository surveyHappinessRepository;

    @Autowired
    private StatisticService statisticService;

    @Test
    void getStatistics() {
        when(surveyFootballRepository.uniqueTeams()).thenReturn(TestUtil.getUniqueTeams());
        when(surveyFootballRepository.teams()).thenReturn(TestUtil.getAllTeams());
        when(surveyHappinessRepository.avg()).thenReturn(5.5);
        StatisticResponse statisticResponse = statisticService.getStatistics();
        assertEquals(statisticResponse, TestUtil.getStatisticsResponse());
    }

}

package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.model.StatisticResponse;
import com.volthread.volthreadreporting.service.StatisticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StatisticControllerTest {
    @MockBean
    StatisticService statisticService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStatistics() throws Exception {
        StatisticResponse statisticResponse = TestUtil.getStatisticsResponse();
        when(statisticService.getStatistics()).thenReturn(statisticResponse);
        mockMvc.perform(get("/statistics"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.happinessRate").value(statisticResponse.getHappinessRate()))
                .andExpect(jsonPath("$.teamRatio").value(statisticResponse.getTeamRatio()));
    }
}

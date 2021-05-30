package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StatisticControllerTest {
    @MockBean
    StatisticService statisticService;

    @Autowired
    MockMvc mockMvc;
}

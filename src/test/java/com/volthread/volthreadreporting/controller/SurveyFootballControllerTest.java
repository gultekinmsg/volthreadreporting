package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.service.SurveyFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SurveyFootballControllerTest {
    @MockBean
    SurveyFootballService surveyFootballService;

    @Autowired
    MockMvc mockMvc;
}

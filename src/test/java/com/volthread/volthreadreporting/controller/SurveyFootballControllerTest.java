package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.service.SurveyFootballService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SurveyFootballControllerTest {
    @MockBean
    SurveyFootballService surveyFootballService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void createSurveyFootball() throws Exception {
        FootballRequest footballRequest = TestUtil.getFootballRequest();
        mockMvc.perform(post("/football")
                .content(TestUtil.asJsonString(footballRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void deleteSurveyFootball() throws Exception {
        Long footballId = 1L;
        SurveyFootball surveyFootball = TestUtil.getFootball(footballId, "random");
        mockMvc.perform(delete("/football/delete/{footballId}", footballId)
                .content(TestUtil.asJsonString(surveyFootball))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void changeSurveyFootball() throws Exception {
        Long footballId = 1L;
        SurveyFootball surveyFootball = TestUtil.getFootball(footballId, "random");
        mockMvc.perform(put("/football/change/{footballId}", footballId)
                .content(TestUtil.asJsonString(surveyFootball))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getSurveyFootball() throws Exception {
        List<FootballResponse> footballResponseList = Mapper.getAllFootballResponse(TestUtil.getAllFootballList());
        when(surveyFootballService.getFootballSurveys()).thenReturn(footballResponseList);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        mockMvc.perform(get("/football"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(footballResponseList.size())))
                .andExpect(jsonPath("$[0].id").value(footballResponseList.get(0).getId()))
                .andExpect(jsonPath("$[0].fanOf").value(footballResponseList.get(0).getFanOf()))
                .andExpect(jsonPath("$[0].explanation").value(footballResponseList.get(0).getExplanation()))
                .andExpect(jsonPath("$[0].pollsterName").value(footballResponseList.get(0).getPollsterName()))
                .andExpect(jsonPath("$[0].pollsterSurname").value(footballResponseList.get(0).getPollsterSurname()))
                .andExpect(jsonPath("$[0].name").value(footballResponseList.get(0).getName()))
                .andExpect(jsonPath("$[0].surname").value(footballResponseList.get(0).getSurname()))
                .andExpect(jsonPath("$[0].gender").value(footballResponseList.get(0).getGender().toString()))
                .andExpect(jsonPath("$[0].birthDate").value(formatter.format(footballResponseList.get(0).getBirthDate())))
                .andExpect(jsonPath("$[1].id").value(footballResponseList.get(1).getId()))
                .andExpect(jsonPath("$[1].fanOf").value(footballResponseList.get(1).getFanOf()))
                .andExpect(jsonPath("$[1].explanation").value(footballResponseList.get(1).getExplanation()))
                .andExpect(jsonPath("$[1].pollsterName").value(footballResponseList.get(1).getPollsterName()))
                .andExpect(jsonPath("$[1].pollsterSurname").value(footballResponseList.get(1).getPollsterSurname()))
                .andExpect(jsonPath("$[1].name").value(footballResponseList.get(1).getName()))
                .andExpect(jsonPath("$[1].surname").value(footballResponseList.get(1).getSurname()))
                .andExpect(jsonPath("$[1].gender").value(footballResponseList.get(1).getGender().toString()))
                .andExpect(jsonPath("$[1].birthDate").value(formatter.format(footballResponseList.get(1).getBirthDate())))
                .andExpect(jsonPath("$[2].id").value(footballResponseList.get(2).getId()))
                .andExpect(jsonPath("$[2].fanOf").value(footballResponseList.get(2).getFanOf()))
                .andExpect(jsonPath("$[2].explanation").value(footballResponseList.get(2).getExplanation()))
                .andExpect(jsonPath("$[2].pollsterName").value(footballResponseList.get(2).getPollsterName()))
                .andExpect(jsonPath("$[2].pollsterSurname").value(footballResponseList.get(2).getPollsterSurname()))
                .andExpect(jsonPath("$[2].name").value(footballResponseList.get(2).getName()))
                .andExpect(jsonPath("$[2].surname").value(footballResponseList.get(2).getSurname()))
                .andExpect(jsonPath("$[2].gender").value(footballResponseList.get(2).getGender().toString()))
                .andExpect(jsonPath("$[2].birthDate").value(formatter.format(footballResponseList.get(3).getBirthDate())))
                .andExpect(jsonPath("$[3].id").value(footballResponseList.get(3).getId()))
                .andExpect(jsonPath("$[3].fanOf").value(footballResponseList.get(3).getFanOf()))
                .andExpect(jsonPath("$[3].explanation").value(footballResponseList.get(3).getExplanation()))
                .andExpect(jsonPath("$[3].pollsterName").value(footballResponseList.get(3).getPollsterName()))
                .andExpect(jsonPath("$[3].pollsterSurname").value(footballResponseList.get(3).getPollsterSurname()))
                .andExpect(jsonPath("$[3].name").value(footballResponseList.get(3).getName()))
                .andExpect(jsonPath("$[3].surname").value(footballResponseList.get(3).getSurname()))
                .andExpect(jsonPath("$[3].gender").value(footballResponseList.get(3).getGender().toString()))
                .andExpect(jsonPath("$[3].birthDate").value(formatter.format(footballResponseList.get(4).getBirthDate())))
                .andExpect(jsonPath("$[4].id").value(footballResponseList.get(4).getId()))
                .andExpect(jsonPath("$[4].fanOf").value(footballResponseList.get(4).getFanOf()))
                .andExpect(jsonPath("$[4].explanation").value(footballResponseList.get(4).getExplanation()))
                .andExpect(jsonPath("$[4].pollsterName").value(footballResponseList.get(4).getPollsterName()))
                .andExpect(jsonPath("$[4].pollsterSurname").value(footballResponseList.get(4).getPollsterSurname()))
                .andExpect(jsonPath("$[4].name").value(footballResponseList.get(4).getName()))
                .andExpect(jsonPath("$[4].surname").value(footballResponseList.get(4).getSurname()))
                .andExpect(jsonPath("$[4].gender").value(footballResponseList.get(4).getGender().toString()))
                .andExpect(jsonPath("$[4].birthDate").value(formatter.format(footballResponseList.get(5).getBirthDate())))
                .andExpect(jsonPath("$[5].id").value(footballResponseList.get(5).getId()))
                .andExpect(jsonPath("$[5].fanOf").value(footballResponseList.get(5).getFanOf()))
                .andExpect(jsonPath("$[5].explanation").value(footballResponseList.get(5).getExplanation()))
                .andExpect(jsonPath("$[5].pollsterName").value(footballResponseList.get(5).getPollsterName()))
                .andExpect(jsonPath("$[5].pollsterSurname").value(footballResponseList.get(5).getPollsterSurname()))
                .andExpect(jsonPath("$[5].name").value(footballResponseList.get(5).getName()))
                .andExpect(jsonPath("$[5].surname").value(footballResponseList.get(5).getSurname()))
                .andExpect(jsonPath("$[5].gender").value(footballResponseList.get(5).getGender().toString()))
                .andExpect(jsonPath("$[5].birthDate").value(formatter.format(footballResponseList.get(5).getBirthDate())));
    }
}

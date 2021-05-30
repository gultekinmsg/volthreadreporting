package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;
import com.volthread.volthreadreporting.service.SurveyHappinessService;
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
class SurveyHappinessControllerTest {
    @MockBean
    SurveyHappinessService surveyHappinessService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void createSurveyHappiness() throws Exception {
        HappinessRequest happinessRequest = TestUtil.getHappinessRequest();
        mockMvc.perform(post("/happiness")
                .content(TestUtil.asJsonString(happinessRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }


    @Test
    void deleteSurveyHappiness() throws Exception {
        Long happinessId = 1L;
        SurveyHappiness surveyHappiness = TestUtil.getHappiness(happinessId, 5);
        mockMvc.perform(delete("/happiness/delete/{happinessId}", happinessId)
                .content(TestUtil.asJsonString(surveyHappiness))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void changeSurveyHappiness() throws Exception {
        Long happinessId = 1L;
        SurveyHappiness surveyHappiness = TestUtil.getHappiness(happinessId, 5);
        mockMvc.perform(put("/happiness/change/{happinessId}", happinessId)
                .content(TestUtil.asJsonString(surveyHappiness))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getSurveyHappiness() throws Exception {
        List<HappinessResponse> happinessResponseList = Mapper.getAllHappinessResponse(TestUtil.getAllHappinessList());
        when(surveyHappinessService.getHappinessSurveys()).thenReturn(happinessResponseList);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        mockMvc.perform(get("/happiness"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(happinessResponseList.size())))
                .andExpect(jsonPath("$[0].id").value(happinessResponseList.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(happinessResponseList.get(0).getName()))
                .andExpect(jsonPath("$[0].surname").value(happinessResponseList.get(0).getSurname()))
                .andExpect(jsonPath("$[0].gender").value(happinessResponseList.get(0).getGender().toString()))
                .andExpect(jsonPath("$[0].birthDate").value(formatter.format(happinessResponseList.get(0).getBirthDate())))
                .andExpect(jsonPath("$[0].happiness").value(happinessResponseList.get(0).getHappiness()))
                .andExpect(jsonPath("$[0].mostHappy").value(happinessResponseList.get(0).getMostHappy()))
                .andExpect(jsonPath("$[0].mostUnHappy").value(happinessResponseList.get(0).getMostUnHappy()))
                .andExpect(jsonPath("$[0].explanation").value(happinessResponseList.get(0).getExplanation()))
                .andExpect(jsonPath("$[0].pollsterName").value(happinessResponseList.get(0).getPollsterName()))
                .andExpect(jsonPath("$[0].pollsterSurname").value(happinessResponseList.get(0).getPollsterSurname()))
                .andExpect(jsonPath("$[1].id").value(happinessResponseList.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(happinessResponseList.get(1).getName()))
                .andExpect(jsonPath("$[1].surname").value(happinessResponseList.get(1).getSurname()))
                .andExpect(jsonPath("$[1].gender").value(happinessResponseList.get(1).getGender().toString()))
                .andExpect(jsonPath("$[1].birthDate").value(formatter.format(happinessResponseList.get(1).getBirthDate())))
                .andExpect(jsonPath("$[1].happiness").value(happinessResponseList.get(1).getHappiness()))
                .andExpect(jsonPath("$[1].mostHappy").value(happinessResponseList.get(1).getMostHappy()))
                .andExpect(jsonPath("$[1].mostUnHappy").value(happinessResponseList.get(1).getMostUnHappy()))
                .andExpect(jsonPath("$[1].explanation").value(happinessResponseList.get(1).getExplanation()))
                .andExpect(jsonPath("$[1].pollsterName").value(happinessResponseList.get(1).getPollsterName()))
                .andExpect(jsonPath("$[1].pollsterSurname").value(happinessResponseList.get(1).getPollsterSurname()))
                .andExpect(jsonPath("$[2].id").value(happinessResponseList.get(2).getId()))
                .andExpect(jsonPath("$[2].name").value(happinessResponseList.get(2).getName()))
                .andExpect(jsonPath("$[2].surname").value(happinessResponseList.get(2).getSurname()))
                .andExpect(jsonPath("$[2].gender").value(happinessResponseList.get(2).getGender().toString()))
                .andExpect(jsonPath("$[2].birthDate").value(formatter.format(happinessResponseList.get(2).getBirthDate())))
                .andExpect(jsonPath("$[2].happiness").value(happinessResponseList.get(2).getHappiness()))
                .andExpect(jsonPath("$[2].mostHappy").value(happinessResponseList.get(2).getMostHappy()))
                .andExpect(jsonPath("$[2].mostUnHappy").value(happinessResponseList.get(2).getMostUnHappy()))
                .andExpect(jsonPath("$[2].explanation").value(happinessResponseList.get(2).getExplanation()))
                .andExpect(jsonPath("$[2].pollsterName").value(happinessResponseList.get(2).getPollsterName()))
                .andExpect(jsonPath("$[2].pollsterSurname").value(happinessResponseList.get(2).getPollsterSurname()))
                .andExpect(jsonPath("$[3].id").value(happinessResponseList.get(3).getId()))
                .andExpect(jsonPath("$[3].name").value(happinessResponseList.get(3).getName()))
                .andExpect(jsonPath("$[3].surname").value(happinessResponseList.get(3).getSurname()))
                .andExpect(jsonPath("$[3].gender").value(happinessResponseList.get(3).getGender().toString()))
                .andExpect(jsonPath("$[3].birthDate").value(formatter.format(happinessResponseList.get(3).getBirthDate())))
                .andExpect(jsonPath("$[3].happiness").value(happinessResponseList.get(3).getHappiness()))
                .andExpect(jsonPath("$[3].mostHappy").value(happinessResponseList.get(3).getMostHappy()))
                .andExpect(jsonPath("$[3].mostUnHappy").value(happinessResponseList.get(3).getMostUnHappy()))
                .andExpect(jsonPath("$[3].explanation").value(happinessResponseList.get(3).getExplanation()))
                .andExpect(jsonPath("$[3].pollsterName").value(happinessResponseList.get(3).getPollsterName()))
                .andExpect(jsonPath("$[3].pollsterSurname").value(happinessResponseList.get(3).getPollsterSurname()));
    }
}

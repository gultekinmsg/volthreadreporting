package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.HappinessResponse;
import com.volthread.volthreadreporting.repository.SurveyHappinessRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SurveyHappinessServiceTest {
    @MockBean
    private SurveyHappinessRepository surveyHappinessRepository;

    @Autowired
    private SurveyHappinessService surveyHappinessService;

    @Test
    void createHappinessSurvey_GivenRequestApprovedWhenTryToCreateThenShouldCreateSuccessfully() {
        ResponseStatusException expectedException = null;
        try {
            surveyHappinessService.addHappinessSurvey(TestUtil.getHappinessRequest());
        } catch (ResponseStatusException ex) {
            expectedException = ex;
        }
        assertNull(expectedException);
    }

    @Test
    void deleteHappinessSurvey_GivenRequestHasReturnInDbWhenTryToDeleteThenShouldDeleteSuccessfully() {
        when(surveyHappinessRepository.findSurveyHappinessById(4L)).thenReturn(TestUtil.getHappiness(4L, 5));
        ResponseStatusException responseStatusException = null;
        try {
            surveyHappinessService.deleteHappiness(4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNull(responseStatusException);
    }

    @Test
    void deleteHappinessSurvey_GivenRequestHasNotReturnInDbWhenTryToDeleteThenShouldThrowNotFoundException() {
        when(surveyHappinessRepository.findSurveyHappinessById(4L)).thenReturn(null);
        ResponseStatusException responseStatusException = null;
        try {
            surveyHappinessService.deleteHappiness(4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }

    @Test
    void changeHappinessSurvey_GivenRequestHasReturnInDbWhenTryToChangeThenShouldChangeSuccessfully() {
        when(surveyHappinessRepository.findSurveyHappinessById(4L)).thenReturn(TestUtil.getHappiness(4L, 5));
        ResponseStatusException responseStatusException = null;
        try {
            surveyHappinessService.changeHappiness(TestUtil.getHappinessRequest(), 4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNull(responseStatusException);
    }

    @Test
    void changeHappinessSurvey_GivenRequestHasNotReturnInDbWhenTryToChangeThenShouldThrowNotFoundException() {
        when(surveyHappinessRepository.findSurveyHappinessById(4L)).thenReturn(null);
        ResponseStatusException responseStatusException = null;
        try {
            surveyHappinessService.changeHappiness(TestUtil.getHappinessRequest(), 4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }

    @Test
    void getHappinessSurvey_GivenRequestHasReturnInDbWhenTryToGetThenShouldGetSuccessfully() {
        List<SurveyHappiness> happinessResponseList = TestUtil.getAllHappinessList();
        when(surveyHappinessRepository.findAll()).thenReturn(happinessResponseList);
        List<HappinessResponse> happinessResponses = surveyHappinessService.getHappinessSurveys();
        assertEquals(happinessResponses, Mapper.getAllHappinessResponse(happinessResponseList));
    }

    @Test
    void getHappinessSurvey_GivenRequestHasNotReturnInDbWhenTryToGetThenShouldThrowNotFoundException() {
        when(surveyHappinessRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseStatusException responseStatusException = null;
        try {
            surveyHappinessService.getHappinessSurveys();
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }
}

package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.TestUtil;
import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.repository.SurveyFootballRepository;
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
class SurveyFootballServiceTest {
    @MockBean
    private SurveyFootballRepository surveyFootballRepository;

    @Autowired
    private SurveyFootballService surveyFootballService;

    @Test
    void createFootballSurvey_GivenRequestApprovedWhenTryToCreateThenShouldCreateSuccessfully() {
        ResponseStatusException expectedException = null;
        try {
            surveyFootballService.addFootballSurvey(TestUtil.getFootballRequest());
        } catch (ResponseStatusException ex) {
            expectedException = ex;
        }
        assertNull(expectedException);
    }

    @Test
    void deleteFootballSurvey_GivenRequestHasReturnInDbWhenTryToDeleteThenShouldDeleteSuccessfully() {
        when(surveyFootballRepository.findSurveyFootballById(4L)).thenReturn(TestUtil.getFootball(4L, "random"));
        ResponseStatusException responseStatusException = null;
        try {
            surveyFootballService.deleteFootball(4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNull(responseStatusException);
    }

    @Test
    void deleteFootballSurvey_GivenRequestHasNotReturnInDbWhenTryToDeleteThenShouldThrowNotFoundException() {
        when(surveyFootballRepository.findSurveyFootballById(4L)).thenReturn(null);
        ResponseStatusException responseStatusException = null;
        try {
            surveyFootballService.deleteFootball(4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }

    @Test
    void changeFootballSurvey_GivenRequestHasReturnInDbWhenTryToChangeThenShouldChangeSuccessfully() {
        when(surveyFootballRepository.findSurveyFootballById(4L)).thenReturn(TestUtil.getFootball(4L, "random"));
        ResponseStatusException responseStatusException = null;
        try {
            surveyFootballService.changeFootball(TestUtil.getFootballRequest(), 4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNull(responseStatusException);
    }

    @Test
    void changeFootballSurvey_GivenRequestHasNotReturnInDbWhenTryToChangeThenShouldThrowNotFoundException() {
        when(surveyFootballRepository.findSurveyFootballById(4L)).thenReturn(null);
        ResponseStatusException responseStatusException = null;
        try {
            surveyFootballService.changeFootball(TestUtil.getFootballRequest(), 4L);
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }

    @Test
    void getFootballSurvey_GivenRequestHasReturnInDbWhenTryToGetThenShouldGetSuccessfully() {
        List<SurveyFootball> footballResponseList = TestUtil.getAllFootballList();
        when(surveyFootballRepository.findAll()).thenReturn(footballResponseList);
        List<FootballResponse> footballResponses = surveyFootballService.getFootballSurveys();
        assertEquals(footballResponses, Mapper.getAllFootballResponse(footballResponseList));
    }

    @Test
    void getFootballSurvey_GivenRequestHasNotReturnInDbWhenTryToGetThenShouldThrowNotFoundException() {
        when(surveyFootballRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseStatusException responseStatusException = null;
        try {
            surveyFootballService.getFootballSurveys();
        } catch (ResponseStatusException exception) {
            responseStatusException = exception;
        }
        assertNotNull(responseStatusException);
    }
}

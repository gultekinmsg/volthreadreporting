package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.service.SurveyFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SurveyFootballController {
    private final SurveyFootballService surveyFootballService;

    @Autowired
    public SurveyFootballController(SurveyFootballService surveyFootballService) {
        this.surveyFootballService = surveyFootballService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/football")
    public void addSurvey(@RequestBody @Valid FootballRequest footballRequest) {
        surveyFootballService.addFootballSurvey(footballRequest);
    }

    @GetMapping("/football")
    public List<FootballResponse> getHappiness() {
        return surveyFootballService.getFootballSurveys();
    }

    @DeleteMapping("/football/delete/{footballId}")
    public void deleteHappiness(@PathVariable Long footballId) {
        surveyFootballService.deleteFootball(footballId);
    }
}

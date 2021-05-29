package com.volthread.volthreadreporting.controller;

import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;
import com.volthread.volthreadreporting.service.SurveyHappinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SurveyHappinessController {
    private final SurveyHappinessService surveyHappinessService;

    @Autowired
    public SurveyHappinessController(SurveyHappinessService surveyHappinessService) {
        this.surveyHappinessService = surveyHappinessService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/happiness")
    public void addSurvey(@RequestBody @Valid HappinessRequest happinessRequest) {
        surveyHappinessService.addHappinessSurvey(happinessRequest);
    }

    @GetMapping("/happiness")
    public List<HappinessResponse> getHappiness() {
        return surveyHappinessService.getHappinessSurveys();
    }

    @DeleteMapping("/happiness/delete/{happinesId}")
    public void deleteHappiness(@PathVariable Long happinesId) {
        surveyHappinessService.deleteHappiness(happinesId);
    }

    @PutMapping("/happiness/change/{happinesId}")
    public void changeHappiness(@RequestBody @Valid HappinessRequest happinessRequest, @PathVariable Long happinesId) {
        surveyHappinessService.changeHappiness(happinessRequest, happinesId);
    }
}

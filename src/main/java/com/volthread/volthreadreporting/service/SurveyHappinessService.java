package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;
import com.volthread.volthreadreporting.repository.SurveyHappinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SurveyHappinessService {
    private final SurveyHappinessRepository surveyHappinessRepository;

    @Autowired
    public SurveyHappinessService(SurveyHappinessRepository surveyHappinessRepository) {
        this.surveyHappinessRepository = surveyHappinessRepository;
    }

    public void addHappinessSurvey(HappinessRequest happinessRequest) {
        SurveyHappiness surveyHappiness = Mapper.getHappiness(happinessRequest);
        surveyHappinessRepository.save(surveyHappiness);
    }

    public List<HappinessResponse> getHappinessSurveys() {
        List<SurveyHappiness> happinessRepositoryAll = surveyHappinessRepository.findAll();
        if (happinessRepositoryAll.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not any happiness survey items");
        }
        return Mapper.getAllHappinessResponse(happinessRepositoryAll);
    }

    public void deleteHappiness(Long id) {
        SurveyHappiness surveyHappiness = surveyHappinessRepository.findSurveyHappinessById(id);
        if (surveyHappiness == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Happiness survey item with id: " + id + " not exist");
        }
        surveyHappinessRepository.delete(surveyHappiness);
    }
}

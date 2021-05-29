package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.entity.Particapator;
import com.volthread.volthreadreporting.entity.Pollster;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;
import com.volthread.volthreadreporting.repository.ParticapatorRepository;
import com.volthread.volthreadreporting.repository.PollsterRepository;
import com.volthread.volthreadreporting.repository.SurveyHappinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SurveyHappinessService {
    private final SurveyHappinessRepository surveyHappinessRepository;
    private final ParticapatorRepository particapatorRepository;
    private final PollsterRepository pollsterRepository;

    @Autowired
    public SurveyHappinessService(SurveyHappinessRepository surveyHappinessRepository, ParticapatorRepository particapatorRepository, PollsterRepository pollsterRepository) {
        this.surveyHappinessRepository = surveyHappinessRepository;
        this.particapatorRepository = particapatorRepository;
        this.pollsterRepository = pollsterRepository;
    }

    public void addHappinessSurvey(HappinessRequest happinessRequest) {
        SurveyHappiness surveyHappiness = saveHappinessSurvey(happinessRequest);
        savePollster(Mapper.getPollster(happinessRequest), surveyHappiness);
        saveParticapator(Mapper.getParticapator(happinessRequest), surveyHappiness);
    }

    public SurveyHappiness saveHappinessSurvey(HappinessRequest happinessRequest) {
        SurveyHappiness surveyHappiness = Mapper.getHappiness(happinessRequest);
        surveyHappinessRepository.save(surveyHappiness);
        return surveyHappiness;
    }

    public void savePollster(Pollster pollster, SurveyHappiness surveyHappiness) {
        pollster.getSurveyHappiness().add(surveyHappiness);
        pollsterRepository.save(pollster);
    }

    public void saveParticapator(Particapator particapator, SurveyHappiness surveyHappiness) {
        particapator.getSurveyHappiness().add(surveyHappiness);
        particapatorRepository.save(particapator);
    }

    public List<HappinessResponse> getHappinessSurveys() {
        List<SurveyHappiness> happinessRepositoryAll = surveyHappinessRepository.findAll();
        if (happinessRepositoryAll.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not any happiness survey items");
        }
        return Mapper.getAllHappinessResponse(happinessRepositoryAll);
    }

    public void deleteHappiness(Long id){
        SurveyHappiness surveyHappiness = surveyHappinessRepository.findSurveyHappinessById(id);
        if (surveyHappiness == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Happiness survey item with id: " + id + " not exist");
        }
        surveyHappinessRepository.delete(surveyHappiness);
    }}

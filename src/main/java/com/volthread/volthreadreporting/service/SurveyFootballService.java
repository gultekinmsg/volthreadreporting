package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.entity.Particapator;
import com.volthread.volthreadreporting.entity.Pollster;
import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.repository.ParticapatorRepository;
import com.volthread.volthreadreporting.repository.PollsterRepository;
import com.volthread.volthreadreporting.repository.SurveyFootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SurveyFootballService {
    private final SurveyFootballRepository surveyFootballRepository;
    private final ParticapatorRepository particapatorRepository;
    private final PollsterRepository pollsterRepository;

    @Autowired
    public SurveyFootballService(SurveyFootballRepository surveyFootballRepository, ParticapatorRepository particapatorRepository, PollsterRepository pollsterRepository) {
        this.surveyFootballRepository = surveyFootballRepository;
        this.particapatorRepository = particapatorRepository;
        this.pollsterRepository = pollsterRepository;
    }

    public void addFootballSurvey(FootballRequest footballRequest) {
        SurveyFootball surveyFootball = saveFootballSurvey(footballRequest);
        savePollster(Mapper.getPollster(footballRequest), surveyFootball);
        saveParticapator(Mapper.getParticapator(footballRequest), surveyFootball);
    }

    public SurveyFootball saveFootballSurvey(FootballRequest footballRequest) {
        SurveyFootball surveyFootball = Mapper.getFootball(footballRequest);
        surveyFootballRepository.save(surveyFootball);
        return surveyFootball;
    }

    public void savePollster(Pollster pollster, SurveyFootball surveyFootball) {
        pollster.getSurveyFootball().add(surveyFootball);
        pollsterRepository.save(pollster);
    }

    public void saveParticapator(Particapator particapator, SurveyFootball surveyFootball) {
        particapator.getSurveyFootball().add(surveyFootball);
        particapatorRepository.save(particapator);
    }

    public List<FootballResponse> getFootballSurveys() {
        List<SurveyFootball> footballRepositoryAll = surveyFootballRepository.findAll();
        if (footballRepositoryAll.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not any football survey items");
        }
        return Mapper.getAllFootballResponse(footballRepositoryAll);
    }

    public void deleteFootball(Long id){
        SurveyFootball surveyFootball = surveyFootballRepository.findSurveyFootballById(id);
        if (surveyFootball == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Football survey item with id: " + id + " not exist");
        }
        surveyFootballRepository.delete(surveyFootball);
    }
}

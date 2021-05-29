package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.mapper.Mapper;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.repository.SurveyFootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SurveyFootballService {
    private final SurveyFootballRepository surveyFootballRepository;

    @Autowired
    public SurveyFootballService(SurveyFootballRepository surveyFootballRepository) {
        this.surveyFootballRepository = surveyFootballRepository;
    }

    public void addFootballSurvey(FootballRequest footballRequest) {
        SurveyFootball surveyFootball = Mapper.getFootball(footballRequest);

        surveyFootballRepository.save(surveyFootball);
    }

    public List<FootballResponse> getFootballSurveys() {
        List<SurveyFootball> footballRepositoryAll = surveyFootballRepository.findAll();
        if (footballRepositoryAll.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not any football survey items");
        }
        return Mapper.getAllFootballResponse(footballRepositoryAll);
    }

    public void deleteFootball(Long id) {
        SurveyFootball surveyFootball = surveyFootballRepository.findSurveyFootballById(id);
        if (surveyFootball == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Football survey item with id: " + id + " not exist");
        }
        surveyFootballRepository.delete(surveyFootball);
    }
}

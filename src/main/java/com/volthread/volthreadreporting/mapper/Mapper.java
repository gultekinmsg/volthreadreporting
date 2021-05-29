package com.volthread.volthreadreporting.mapper;

import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private Mapper() {
    }

    public static SurveyHappiness getHappiness(HappinessRequest happinessRequest) {
        SurveyHappiness surveyHappiness = new SurveyHappiness();
        surveyHappiness.setHappiness(happinessRequest.getHappiness());
        surveyHappiness.setMostHappy(happinessRequest.getMostHappy());
        surveyHappiness.setMostUnHappy(happinessRequest.getMostUnHappy());
        surveyHappiness.setExplanation(happinessRequest.getExplanation());
        surveyHappiness.setPollsterName(happinessRequest.getPollsterName());
        surveyHappiness.setPollsterSurname(happinessRequest.getPollsterSurname());
        surveyHappiness.setName(happinessRequest.getName());
        surveyHappiness.setSurname(happinessRequest.getSurname());
        surveyHappiness.setGender(happinessRequest.getGender());
        surveyHappiness.setBirthDate(happinessRequest.getBirthDate());
        return surveyHappiness;
    }

    public static SurveyFootball getFootball(FootballRequest footballRequest) {
        SurveyFootball surveyFootball = new SurveyFootball();
        surveyFootball.setFanOf(footballRequest.getFanOf());
        surveyFootball.setExplanation(footballRequest.getExplanation());
        surveyFootball.setPollsterName(footballRequest.getPollsterName());
        surveyFootball.setPollsterSurname(footballRequest.getPollsterSurname());
        surveyFootball.setName(footballRequest.getName());
        surveyFootball.setSurname(footballRequest.getSurname());
        surveyFootball.setGender(footballRequest.getGender());
        surveyFootball.setBirthDate(footballRequest.getBirthDate());
        return surveyFootball;
    }

    public static HappinessResponse getHappinessResponse(SurveyHappiness surveyHappiness) {
        HappinessResponse happinessResponse = new HappinessResponse();
        BeanUtils.copyProperties(surveyHappiness, happinessResponse);
        return happinessResponse;
    }

    public static FootballResponse getFootballResponse(SurveyFootball surveyFootball) {
        FootballResponse footballResponse = new FootballResponse();
        BeanUtils.copyProperties(surveyFootball, footballResponse);
        return footballResponse;
    }

    public static List<HappinessResponse> getAllHappinessResponse(List<SurveyHappiness> surveyHappiness) {
        List<HappinessResponse> happinessResponseList = new ArrayList<>();
        surveyHappiness.forEach(surveyHappiness1 -> happinessResponseList.add(getHappinessResponse(surveyHappiness1)));
        return happinessResponseList;
    }

    public static List<FootballResponse> getAllFootballResponse(List<SurveyFootball> surveyFootball) {
        List<FootballResponse> footballResponseList = new ArrayList<>();
        surveyFootball.forEach(surveyFootball1 -> footballResponseList.add(getFootballResponse(surveyFootball1)));
        return footballResponseList;
    }
}

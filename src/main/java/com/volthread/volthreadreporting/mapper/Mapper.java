package com.volthread.volthreadreporting.mapper;

import com.volthread.volthreadreporting.entity.Particapator;
import com.volthread.volthreadreporting.entity.Pollster;
import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.FootballResponse;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.HappinessResponse;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private Mapper() {
    }

    public static Pollster getPollster(HappinessRequest happinessRequest) {
        Pollster pollster = new Pollster();
        pollster.setPollsterName(happinessRequest.getPollsterName());
        pollster.setPollsterSurname(happinessRequest.getPollsterSurname());
        return pollster;
    }

    public static Particapator getParticapator(HappinessRequest happinessRequest) {
        Particapator particapator = new Particapator();
        particapator.setName(happinessRequest.getName());
        particapator.setSurname(happinessRequest.getSurname());
        particapator.setGender(happinessRequest.getGender());
        particapator.setBirthDate(happinessRequest.getBirthDate());
        return particapator;
    }

    public static Pollster getPollster(FootballRequest footballRequest) {
        Pollster pollster = new Pollster();
        pollster.setPollsterName(footballRequest.getPollsterName());
        pollster.setPollsterSurname(footballRequest.getPollsterSurname());
        return pollster;
    }

    public static Particapator getParticapator(FootballRequest footballRequest) {
        Particapator particapator = new Particapator();
        particapator.setName(footballRequest.getName());
        particapator.setSurname(footballRequest.getSurname());
        particapator.setGender(footballRequest.getGender());
        particapator.setBirthDate(footballRequest.getBirthDate());
        return particapator;
    }

    public static SurveyHappiness getHappiness(HappinessRequest happinessRequest) {
        SurveyHappiness surveyHappiness = new SurveyHappiness();
        surveyHappiness.setHappiness(happinessRequest.getHappiness());
        surveyHappiness.setMostHappy(happinessRequest.getMostHappy());
        surveyHappiness.setMostUnHappy(happinessRequest.getMostUnHappy());
        surveyHappiness.setExplanation(happinessRequest.getExplanation());
        return surveyHappiness;
    }

    public static SurveyFootball getFootball(FootballRequest footballRequest) {
        SurveyFootball surveyFootball = new SurveyFootball();
        surveyFootball.setFanOf(footballRequest.getFanOf());
        surveyFootball.setExplanation(footballRequest.getExplanation());
        return surveyFootball;
    }

    public static HappinessResponse getHappinessResponse(Particapator particapator, Pollster pollster, SurveyHappiness surveyHappiness) {
        HappinessResponse happinessResponse = new HappinessResponse();
        happinessResponse.setId(surveyHappiness.getId());
        happinessResponse.setName(particapator.getName());
        happinessResponse.setSurname(particapator.getSurname());
        happinessResponse.setGender(particapator.getGender());
        happinessResponse.setBirthDate(particapator.getBirthDate());
        happinessResponse.setMostHappy(surveyHappiness.getMostHappy());
        happinessResponse.setMostUnHappy(surveyHappiness.getMostUnHappy());
        happinessResponse.setExplanation(surveyHappiness.getExplanation());
        happinessResponse.setPollsterName(pollster.getPollsterName());
        happinessResponse.setPollsterSurname(pollster.getPollsterSurname());
        return happinessResponse;
    }

    public static FootballResponse getFootballResponse(Particapator particapator, Pollster pollster, SurveyFootball surveyFootball) {
        FootballResponse footballResponse = new FootballResponse();
        footballResponse.setId(surveyFootball.getId());
        footballResponse.setName(particapator.getName());
        footballResponse.setSurname(particapator.getSurname());
        footballResponse.setGender(particapator.getGender());
        footballResponse.setBirthDate(particapator.getBirthDate());
        footballResponse.setFanOf(surveyFootball.getFanOf());
        footballResponse.setExplanation(surveyFootball.getExplanation());
        footballResponse.setPollsterName(pollster.getPollsterName());
        footballResponse.setPollsterSurname(pollster.getPollsterSurname());
        return footballResponse;
    }

    public static List<HappinessResponse> getAllHappinessResponse(List<SurveyHappiness> surveyHappiness) {
        List<HappinessResponse> happinessResponseList = new ArrayList<>();
        surveyHappiness.forEach(surveyHappiness1 -> happinessResponseList.add(getHappinessResponse(surveyHappiness1.getParticapator(), surveyHappiness1.getPollster(), surveyHappiness1)));
        return happinessResponseList;
    }

    public static List<FootballResponse> getAllFootballResponse(List<SurveyFootball> surveyFootball) {
        List<FootballResponse> footballResponseList = new ArrayList<>();
        surveyFootball.forEach(surveyFootball1 -> footballResponseList.add(getFootballResponse(surveyFootball1.getParticapator(), surveyFootball1.getPollster(), surveyFootball1)));
        return footballResponseList;
    }
}

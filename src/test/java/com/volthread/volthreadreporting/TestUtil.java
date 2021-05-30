package com.volthread.volthreadreporting;

import com.volthread.volthreadreporting.entity.Gender;
import com.volthread.volthreadreporting.entity.SurveyFootball;
import com.volthread.volthreadreporting.entity.SurveyHappiness;
import com.volthread.volthreadreporting.model.FootballRequest;
import com.volthread.volthreadreporting.model.HappinessRequest;
import com.volthread.volthreadreporting.model.StatisticResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestUtil {
    private TestUtil() {
    }


    public static List<String> getUniqueTeams(){
        List<String> teamsList = new ArrayList<>();
        teamsList.add("random");
        teamsList.add("first");
        teamsList.add("second");
        return teamsList;
    }

    public static List<String> getAllTeams(){
        List<String> teamsList = new ArrayList<>();
        teamsList.add("random");
        teamsList.add("first");
        teamsList.add("first");
        teamsList.add("first");
        teamsList.add("second");
        teamsList.add("second");
        return teamsList;
    }

    public static StatisticResponse getStatisticsResponse(){
        HashMap<String,Integer> teamMap = new HashMap<>();
        teamMap.put("random",16);
        teamMap.put("first",50);
        teamMap.put("second",33);
        StatisticResponse statisticResponse = new StatisticResponse();
        statisticResponse.setHappinessRate(5.5);
        statisticResponse.setTeamRatio(teamMap);
        return statisticResponse;
    }

    public static List<SurveyFootball> getAllFootballList(){
        List<SurveyFootball> footballRepositoryAll = new ArrayList<>();
        footballRepositoryAll.add(getFootball(10L,"random"));
        footballRepositoryAll.add(getFootball(15L,"first"));
        footballRepositoryAll.add(getFootball(16L,"first"));
        footballRepositoryAll.add(getFootball(17L,"first"));
        footballRepositoryAll.add(getFootball(18L,"first"));
        footballRepositoryAll.add(getFootball(19L,"first"));
        return footballRepositoryAll;
    }
    public static SurveyFootball getFootball(Long id,String team){
        SurveyFootball footballResponse = new SurveyFootball();
        footballResponse.setId(id);
        footballResponse.setName("responseName");
        footballResponse.setSurname("responseSurname");
        footballResponse.setGender(Gender.MALE);
        footballResponse.setBirthDate(new Date());
        footballResponse.setFanOf(team);
        footballResponse.setExplanation("responseExplanation");
        footballResponse.setPollsterName("pollsterName");
        footballResponse.setPollsterSurname("pollsterSurname");
        return footballResponse;
    }
    public static List<SurveyHappiness> getAllHappinessList(){
        List<SurveyHappiness> surveyHappinessList = new ArrayList<>();
        surveyHappinessList.add(getHappiness(11L,8));
        surveyHappinessList.add(getHappiness(12L,4));
        surveyHappinessList.add(getHappiness(13L,8));
        surveyHappinessList.add(getHappiness(14L,2));
        return surveyHappinessList;
    }
    public static SurveyHappiness getHappiness(Long id,Integer happiness){
        SurveyHappiness surveyHappiness = new SurveyHappiness();
        surveyHappiness.setId(id);
        surveyHappiness.setHappiness(happiness);
        surveyHappiness.setMostHappy("mostHappy");
        surveyHappiness.setMostUnHappy("mostUnHappy");
        surveyHappiness.setExplanation("happinessExplanation");
        surveyHappiness.setPollsterName("pollsterName");
        surveyHappiness.setPollsterSurname("pollsterSurname");
        surveyHappiness.setName("responseName");
        surveyHappiness.setSurname("responseSurname");
        surveyHappiness.setGender(Gender.FEMALE);
        surveyHappiness.setBirthDate(new Date());
        return surveyHappiness;
    }
    public static FootballRequest getFootballRequest(){
        FootballRequest footballResponse = new FootballRequest();
        footballResponse.setName("responseName");
        footballResponse.setSurname("responseSurname");
        footballResponse.setGender(Gender.MALE);
        footballResponse.setBirthDate(new Date());
        footballResponse.setFanOf("random");
        footballResponse.setExplanation("responseExplanation");
        footballResponse.setPollsterName("pollsterName");
        footballResponse.setPollsterSurname("pollsterSurname");
        return footballResponse;
    }
    public static HappinessRequest getHappinessRequest(){
        HappinessRequest surveyHappiness = new HappinessRequest();
        surveyHappiness.setHappiness(5);
        surveyHappiness.setMostHappy("mostHappy");
        surveyHappiness.setMostUnHappy("mostUnHappy");
        surveyHappiness.setExplanation("happinessExplanation");
        surveyHappiness.setPollsterName("pollsterName");
        surveyHappiness.setPollsterSurname("pollsterSurname");
        surveyHappiness.setName("responseName");
        surveyHappiness.setSurname("responseSurname");
        surveyHappiness.setGender(Gender.FEMALE);
        surveyHappiness.setBirthDate(new Date());
        return surveyHappiness;
    }
}

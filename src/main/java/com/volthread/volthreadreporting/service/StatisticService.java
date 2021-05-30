package com.volthread.volthreadreporting.service;

import com.volthread.volthreadreporting.model.StatisticResponse;
import com.volthread.volthreadreporting.repository.SurveyFootballRepository;
import com.volthread.volthreadreporting.repository.SurveyHappinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class StatisticService {
    private final SurveyFootballRepository surveyFootballRepository;
    private final SurveyHappinessRepository surveyHappinessRepository;

    @Autowired
    public StatisticService(SurveyFootballRepository surveyFootballRepository, SurveyHappinessRepository surveyHappinessRepository) {
        this.surveyFootballRepository = surveyFootballRepository;
        this.surveyHappinessRepository = surveyHappinessRepository;
    }

    public StatisticResponse getStatistics() {
        StatisticResponse statisticResponse = new StatisticResponse();
        statisticResponse.setTeamRatio(calculateTeamRatio());
        statisticResponse.setHappinessRate(calculateHappiness());
        return statisticResponse;
    }

    public Double calculateHappiness() {
        return surveyHappinessRepository.avg();
    }

    public HashMap<String, Integer> calculateTeamRatio() {
        List<String> uniqueSurveyTeams = surveyFootballRepository.uniqueTeams();
        HashMap<String, Integer> fanCount = new HashMap<>();
        for (String uniqueSurveyTeam : uniqueSurveyTeams) {
            fanCount.put(uniqueSurveyTeam.toLowerCase(Locale.ROOT), 0);
        }
        List<String> allSurveyTeams = surveyFootballRepository.teams();
        Integer voteCount = allSurveyTeams.size();

        for (String allSurveyTeam : allSurveyTeams) {
            fanCount.put(allSurveyTeam.toLowerCase(Locale.ROOT), fanCount.get(allSurveyTeam.toLowerCase(Locale.ROOT)) + 1);
        }
        for (String uniqueSurveyTeam : uniqueSurveyTeams) {
            fanCount.put(uniqueSurveyTeam.toLowerCase(Locale.ROOT), calculatePercentage(fanCount.get(uniqueSurveyTeam.toLowerCase(Locale.ROOT)), voteCount));
        }
        return fanCount;
    }

    public Integer calculatePercentage(Integer thisOne, Integer total) {
        return (thisOne * 100) / total;
    }
}

























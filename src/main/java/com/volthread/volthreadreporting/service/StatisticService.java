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
        Integer teamCount = uniqueSurveyTeams.size();
        HashMap<String, Integer> fanCount = new HashMap<>();
        for (int i = 0; i < teamCount; i++) {
            fanCount.put(uniqueSurveyTeams.get(i).toLowerCase(Locale.ROOT), 0);
        }
        List<String> allSurveyTeams = surveyFootballRepository.teams();
        Integer voteCount = allSurveyTeams.size();

        for (int j = 0; j < voteCount; j++) {
            fanCount.put(allSurveyTeams.get(j).toLowerCase(Locale.ROOT), fanCount.get(allSurveyTeams.get(j).toLowerCase(Locale.ROOT)) + 1);
        }
        for (int k = 0; k < teamCount; k++) {
            fanCount.put(uniqueSurveyTeams.get(k).toLowerCase(Locale.ROOT), calculatePerCentage(fanCount.get(uniqueSurveyTeams.get(k).toLowerCase(Locale.ROOT)), voteCount));
        }
        return fanCount;
    }

    public Integer calculatePerCentage(Integer thisOne, Integer total) {
        return (thisOne * 100) / total;
    }
}

























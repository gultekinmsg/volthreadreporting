package com.volthread.volthreadreporting.repository;

import com.volthread.volthreadreporting.entity.SurveyFootball;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyFootballRepository extends CrudRepository<SurveyFootball, Long> {
    List<SurveyFootball> findAll();

    SurveyFootball findSurveyFootballById(Long id);

    @Query("select fanOf from SurveyFootball")
    List<String> teams();

    @Query("select distinct fanOf from SurveyFootball")
    List<String> uniqueTeams();
}

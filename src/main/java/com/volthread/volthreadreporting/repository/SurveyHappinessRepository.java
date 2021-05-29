package com.volthread.volthreadreporting.repository;

import com.volthread.volthreadreporting.entity.SurveyHappiness;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyHappinessRepository extends CrudRepository<SurveyHappiness, Long> {
    List<SurveyHappiness> findAll();

    SurveyHappiness findSurveyHappinessById(Long id);
}

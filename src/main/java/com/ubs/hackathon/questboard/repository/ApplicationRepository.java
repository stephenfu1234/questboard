package com.ubs.hackathon.questboard.repository;

import com.ubs.hackathon.questboard.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value="select * from application a where a.quest_id = ?1", nativeQuery=true)
    Optional<List<Application>> findByQuestId(Integer questId);

    @Query(value="select * from application a where a.ubs_user_id = ?1", nativeQuery=true)
    Optional<List<Application>> findByUserId(Integer userId);

}

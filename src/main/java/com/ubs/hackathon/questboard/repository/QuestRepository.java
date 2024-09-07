package com.ubs.hackathon.questboard.repository;

import com.ubs.hackathon.questboard.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Integer> {

    @Query(value="select * from quest u where u.status = ?1", nativeQuery=true)
    List<Quest> findAllQuestsByStatus(String status);

    @Query(value="select name as questHero, count(1) as totalQuests, sum(q.kudos_points) as totalKudos " +
            "    from quest q, application a, ubs_user u " +
            "    where q.id = a.quest_id" +
            "    and q.status = 'Completed'" +
            "    and a.is_selected = true" +
            "    and a.ubs_user_id = u.id" +
            "    group by u.name" +
            "    order by count(1) desc", nativeQuery = true)
    List<LeaderboardPosition> leaderboard();

    interface LeaderboardPosition {
        String getQuestHero();
        Integer getTotalQuests();
        Integer getTotalKudos();
    }

}

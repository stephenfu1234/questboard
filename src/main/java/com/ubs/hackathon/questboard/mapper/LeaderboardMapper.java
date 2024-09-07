package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.LeaderboardDto;
import com.ubs.hackathon.questboard.dto.LeaderboardPositionDto;
import com.ubs.hackathon.questboard.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardMapper {

    public static LeaderboardDto mapToLeaderboardDto(List<QuestRepository.LeaderboardPosition> positions, LeaderboardDto leaderboardDto) {
        List<LeaderboardPositionDto> leaderboardPositionDtos = new ArrayList<>();

        for(int i = 0; i< positions.size(); i++) {
            LeaderboardPositionDto leaderboardPositionDto = new LeaderboardPositionDto();
            leaderboardPositionDto.setRank(i+1);
            leaderboardPositionDto.setQuestHero(positions.get(i).getQuestHero());
            leaderboardPositionDto.setTotalQuests(positions.get(i).getTotalQuests());
            leaderboardPositionDto.setTotalKudos(positions.get(i).getTotalKudos());
            leaderboardPositionDtos.add(leaderboardPositionDto);
        }

        leaderboardDto.setLeaderboard(leaderboardPositionDtos);
        return leaderboardDto;
    }

}
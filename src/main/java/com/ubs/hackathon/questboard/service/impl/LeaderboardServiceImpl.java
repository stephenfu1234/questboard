package com.ubs.hackathon.questboard.service.impl;

import com.ubs.hackathon.questboard.dto.LeaderboardDto;
import com.ubs.hackathon.questboard.mapper.LeaderboardMapper;
import com.ubs.hackathon.questboard.repository.QuestRepository;
import com.ubs.hackathon.questboard.service.LeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaderboardServiceImpl implements LeaderboardService {

    private QuestRepository questRepository;

    @Override
    public LeaderboardDto getLeaderboard() {
        List<QuestRepository.LeaderboardPosition> positions = questRepository.leaderboard();
        List<QuestRepository.LeaderboardPosition> top5Positions = positions.stream()
                .limit(5)
                .collect(Collectors.toList());

        return LeaderboardMapper.mapToLeaderboardDto(top5Positions, new LeaderboardDto());
    }

}

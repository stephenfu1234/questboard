package com.ubs.hackathon.questboard.dto;

import lombok.Data;

import java.util.List;

@Data
public class LeaderboardDto {

    private List<LeaderboardPositionDto> leaderboard;

}

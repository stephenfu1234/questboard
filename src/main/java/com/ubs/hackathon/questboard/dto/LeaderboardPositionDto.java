package com.ubs.hackathon.questboard.dto;

import lombok.Data;

@Data
public class LeaderboardPositionDto {

    private Integer rank;
    private String questHero;
    private Integer totalQuests;
    private Integer totalKudos;

}

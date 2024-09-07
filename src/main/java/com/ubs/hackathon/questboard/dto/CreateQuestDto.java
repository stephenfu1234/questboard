package com.ubs.hackathon.questboard.dto;

import lombok.Data;

@Data
public class CreateQuestDto {

    private String category;
    private String summary;
    private String techStack;
    private String closingDate;
    private Integer kudosPoints;
    private Integer sponsorId;


}

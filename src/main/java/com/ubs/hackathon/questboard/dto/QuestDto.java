package com.ubs.hackathon.questboard.dto;

import lombok.Data;

@Data
public class QuestDto {

    private Integer questId;
    private String category;
    private String summary;
    private String techStack;
    private String startDate;
    private String closingDate;
    private Integer kudosPoints;
    private String status;
    private UbsUserDto sponsor;

//    private List<Application> applications;

    private Integer totalApplications;

//    private LocalDateTime createdAt;
//    private String createdBy;
//    private LocalDateTime updatedAt;
//    private String updatedBy;

}

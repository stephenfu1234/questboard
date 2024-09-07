package com.ubs.hackathon.questboard.dto;

import com.ubs.hackathon.questboard.entity.Application;
import lombok.Data;

import java.util.List;

@Data
public class QuestApplicationsDto {

    private Integer id;
    private String category;
    private String summary;
    private String techStack;
    private String startDate;
    private String closingDate;
    private Integer kudosPoints;
    private String status;
    private UbsUserDto sponsor;
    private List<Application> applications;
    private Integer totalApplications;

//    private LocalDateTime createdAt;
//    private String createdBy;
//    private LocalDateTime updatedAt;
//    private String updatedBy;

}

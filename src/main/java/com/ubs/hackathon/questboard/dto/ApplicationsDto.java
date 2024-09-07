package com.ubs.hackathon.questboard.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApplicationsDto {

    private Integer questId;
    private String category;
    private String summary;
    private String techStack;
    private String startDate;
    private String closingDate;
    private Integer kudosPoints;
    private String status;
    private UbsUserDto sponsor;
    private List<ApplicationDto> applications = new ArrayList<>();
    private Integer totalApplications;

}

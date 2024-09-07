package com.ubs.hackathon.questboard.dto;

import com.ubs.hackathon.questboard.entity.Quest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {

    private Integer applicationId;
    private Integer questId;
    private String applicantComments;
    private UbsUserDto user;
    private String submittedDate;
    private String status;
    private Boolean isSelected;
    private String sponsorComments;

}

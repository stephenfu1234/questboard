package com.ubs.hackathon.questboard.dto;

import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateApplicationDto {

    private Integer questId;
    private String comments;
    private Integer userId;

}

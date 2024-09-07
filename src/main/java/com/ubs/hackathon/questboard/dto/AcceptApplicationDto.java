package com.ubs.hackathon.questboard.dto;

import com.ubs.hackathon.questboard.entity.Quest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AcceptApplicationDto {

    private int id;
    private String status;
    private String comments;

}

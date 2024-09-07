package com.ubs.hackathon.questboard.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestsDto {

    private List<QuestDto> quests = new ArrayList<>();

}

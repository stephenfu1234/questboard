package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.CreateQuestDto;
import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateQuestMapper {

    public static Quest mapToQuest(CreateQuestDto createQuestDto, Quest quest, UbsUser sponsor) {
        quest.setCategory(createQuestDto.getCategory());
        quest.setSummary(createQuestDto.getSummary());
        quest.setTechStack(createQuestDto.getTechStack());
        quest.setStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        quest.setClosingDate(createQuestDto.getClosingDate());
        quest.setKudosPoints(createQuestDto.getKudosPoints());
        quest.setSponsor(sponsor);

        return quest;
    }

}
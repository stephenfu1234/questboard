package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.CompleteQuestDto;
import com.ubs.hackathon.questboard.dto.QuestDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.entity.Quest;

import java.util.ArrayList;

public class QuestMapper {

    public static QuestDto mapToQuestDto(Quest quest, QuestDto questDto) {
        questDto.setQuestId(quest.getId());
        questDto.setCategory(quest.getCategory());
        questDto.setSummary(quest.getSummary());
        questDto.setTechStack(quest.getTechStack());
        questDto.setStartDate(quest.getStartDate());
        questDto.setClosingDate(quest.getClosingDate());
        questDto.setKudosPoints(quest.getKudosPoints());
        questDto.setStatus(quest.getStatus());

        questDto.setSponsor(UbsUserMapper.mapToUbsUserDto(quest.getSponsor(), new UbsUserDto()));
//        if(quest.getApplications() == null) {
//            questDto.setApplications(new ArrayList<>());
//        }
//        questDto.setApplications(quest.getApplications());
        questDto.setTotalApplications(quest.getApplications().size());

//        questDto.setCreatedAt(quest.getCreatedAt());
//        questDto.setCreatedBy(quest.getCreatedBy());
//        questDto.setUpdatedAt(quest.getUpdatedAt());
//        questDto.setUpdatedBy(quest.getUpdatedBy());
        return questDto;
    }

    public static Quest mapToQuest(QuestDto questDto, Quest quest) {
        quest.setId(questDto.getQuestId());

        quest.setCategory(questDto.getCategory());
        quest.setSummary(questDto.getSummary());
        quest.setTechStack(questDto.getTechStack());
        quest.setStartDate(questDto.getStartDate());
        quest.setClosingDate(questDto.getClosingDate());
        quest.setKudosPoints(questDto.getKudosPoints());
        quest.setStatus(questDto.getStatus());

        // don't overwrite applications or sponsor

//        quest.setCreatedAt(questDto.getCreatedAt());
//        quest.setCreatedBy(questDto.getCreatedBy());
//        quest.setUpdatedAt(questDto.getUpdatedAt());
//        quest.setUpdatedBy(questDto.getUpdatedBy());
        return quest;
    }

    public static Quest mapToQuest(CompleteQuestDto completeQuestDto, Quest quest) {
        quest.setStatus(completeQuestDto.getStatus());

        return quest;
    }

}
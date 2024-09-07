package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.QuestApplicationsDto;
import com.ubs.hackathon.questboard.dto.QuestDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.entity.Quest;

import java.util.ArrayList;

public class QuestApplicationsMapper {

    public static QuestApplicationsDto mapToQuestApplicationsDto(Quest quest, QuestApplicationsDto questApplicationsDto) {
        questApplicationsDto.setId(quest.getId());
        questApplicationsDto.setCategory(quest.getCategory());
        questApplicationsDto.setSummary(quest.getSummary());
        questApplicationsDto.setTechStack(quest.getTechStack());
        questApplicationsDto.setStartDate(quest.getStartDate());
        questApplicationsDto.setClosingDate(quest.getClosingDate());
        questApplicationsDto.setKudosPoints(quest.getKudosPoints());
        questApplicationsDto.setStatus(quest.getStatus());

        questApplicationsDto.setSponsor(UbsUserMapper.mapToUbsUserDto(quest.getSponsor(), new UbsUserDto()));
        if(quest.getApplications() == null) {
            questApplicationsDto.setApplications(new ArrayList<>());
        }
        questApplicationsDto.setApplications(quest.getApplications());
        questApplicationsDto.setTotalApplications(quest.getApplications().size());

//        questApplicationsDto.setCreatedAt(quest.getCreatedAt());
//        questApplicationsDto.setCreatedBy(quest.getCreatedBy());
//        questApplicationsDto.setUpdatedAt(quest.getUpdatedAt());
//        questApplicationsDto.setUpdatedBy(quest.getUpdatedBy());
        return questApplicationsDto;
    }

}
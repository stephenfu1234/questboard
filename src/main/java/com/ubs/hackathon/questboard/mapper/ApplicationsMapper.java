package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.ApplicationDto;
import com.ubs.hackathon.questboard.dto.ApplicationsDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.entity.Application;
import com.ubs.hackathon.questboard.entity.Quest;

import java.util.List;

public class ApplicationsMapper {

    public static ApplicationsDto mapToApplicationsDto(Quest quest, List<Application> applications, ApplicationsDto applicationsDto) {
        applicationsDto.setQuestId(quest.getId());
        applicationsDto.setCategory(quest.getCategory());
        applicationsDto.setSummary(quest.getSummary());
        applicationsDto.setTechStack(quest.getTechStack());
        applicationsDto.setStartDate(quest.getStartDate());
        applicationsDto.setClosingDate(quest.getClosingDate());
        applicationsDto.setKudosPoints(quest.getKudosPoints());
        applicationsDto.setStatus(quest.getStatus());

        applicationsDto.setSponsor(UbsUserMapper.mapToUbsUserDto(quest.getSponsor(), new UbsUserDto()));

        for(Application application: applications) {
            ApplicationDto applicationDto = ApplicationMapper.mapToApplicationDto(quest, application, new ApplicationDto());
            applicationsDto.getApplications().add(applicationDto);
        }
        applicationsDto.setTotalApplications(applications.size());
        return applicationsDto;
    }

}
package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.CreateApplicationDto;
import com.ubs.hackathon.questboard.entity.Application;
import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;

public class CreateApplicationMapper {

    public static Application mapToApplication(CreateApplicationDto createApplicationDto, Quest quest, Application application, UbsUser ubsUser) {
        application.setQuest(quest);
        application.setApplicantComments(createApplicationDto.getComments());
        application.setIsSelected(false);
        application.setUser(ubsUser);
        application.setStatus("Open");
        application.setSponsorComments("");
        return application;
    }

}
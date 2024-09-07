package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.AcceptApplicationDto;
import com.ubs.hackathon.questboard.dto.ApplicationDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.entity.Application;
import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;

public class ApplicationMapper {

    public static ApplicationDto mapToApplicationDto(Quest quest, Application application, ApplicationDto applicationDto) {
        applicationDto.setApplicationId(application.getId());
        applicationDto.setQuestId(quest.getId());

        applicationDto.setApplicantComments(application.getApplicantComments());
        applicationDto.setUser(UbsUserMapper.mapToUbsUserDto(application.getUser(), new UbsUserDto()));
        applicationDto.setSubmittedDate(application.getSubmittedDate());
        applicationDto.setStatus(application.getStatus());
        applicationDto.setIsSelected(application.getIsSelected());
        applicationDto.setSponsorComments(application.getSponsorComments());

//        applicationDto.setCreatedAt(application.getCreatedAt());
//        applicationDto.setCreatedBy(application.getCreatedBy());
//        applicationDto.setUpdatedAt(application.getUpdatedAt());
//        applicationDto.setUpdatedBy(application.getUpdatedBy());
        return applicationDto;
    }

    public static Application mapToApplication(ApplicationDto applicationDto, Application application) {
        application.setId(applicationDto.getApplicationId());
        application.setApplicantComments(applicationDto.getApplicantComments());
        application.setUser(UbsUserMapper.mapToUbsUser(applicationDto.getUser(), new UbsUser()));
        application.setSubmittedDate(applicationDto.getSubmittedDate());
        application.setStatus(applicationDto.getStatus());
        application.setIsSelected(applicationDto.getIsSelected());
        application.setSponsorComments(applicationDto.getSponsorComments());

//        application.setCreatedAt(applicationDto.getCreatedAt());
//        application.setCreatedBy(applicationDto.getCreatedBy());
//        application.setUpdatedAt(applicationDto.getUpdatedAt());
//        application.setUpdatedBy(applicationDto.getUpdatedBy());
        return application;
    }

    public static Application mapToApplication(AcceptApplicationDto acceptAplicationDto, Application application) {
        application.setStatus(acceptAplicationDto.getStatus());
        application.setIsSelected(true);
        application.setSponsorComments(acceptAplicationDto.getComments());
        return application;
    }

}
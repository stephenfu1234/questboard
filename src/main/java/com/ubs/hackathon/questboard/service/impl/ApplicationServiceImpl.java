package com.ubs.hackathon.questboard.service.impl;

import com.ubs.hackathon.questboard.dto.*;
import com.ubs.hackathon.questboard.entity.Application;
import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;
import com.ubs.hackathon.questboard.exception.ResourceNotFoundException;
import com.ubs.hackathon.questboard.mapper.ApplicationMapper;
import com.ubs.hackathon.questboard.mapper.ApplicationsMapper;
import com.ubs.hackathon.questboard.mapper.CreateApplicationMapper;
import com.ubs.hackathon.questboard.mapper.QuestMapper;
import com.ubs.hackathon.questboard.repository.ApplicationRepository;
import com.ubs.hackathon.questboard.repository.QuestRepository;
import com.ubs.hackathon.questboard.repository.UbsUserRepository;
import com.ubs.hackathon.questboard.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private QuestRepository questRepository;
    private ApplicationRepository applicationRepository;
    private UbsUserRepository ubsUserRepository;

    @Override
    public ApplicationsDto getAllApplicationsForQuest(int questId) {
        Quest quest = questRepository.findById(questId).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(questId))
        );

        List<Application> applications = applicationRepository.findByQuestId(questId).orElse(new ArrayList<>());

        return ApplicationsMapper.mapToApplicationsDto(quest, applications, new ApplicationsDto());
    }

    @Override
    public ApplicationDto getApplication(int questId, int applicationId) {
        Quest quest = questRepository.findById(questId).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(questId))
        );

        Application application = applicationRepository.findById(applicationId).orElseThrow(
                () -> new ResourceNotFoundException("Application", "id", String.valueOf(applicationId))
        );
        return ApplicationMapper.mapToApplicationDto(quest, application, new ApplicationDto());
    }

    @Override
    public void createApplication(CreateApplicationDto createApplicationDto) {
        Application application = new Application();

        Quest quest = questRepository.findById(createApplicationDto.getQuestId()).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(createApplicationDto.getQuestId()))
        );

        UbsUser ubsUser = ubsUserRepository.findById(createApplicationDto.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("UbsUser", "id", String.valueOf(createApplicationDto.getUserId()))
        );
        CreateApplicationMapper.mapToApplication(createApplicationDto, quest, application, ubsUser);
        application.setSubmittedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        applicationRepository.save(application);
    }

    @Override
    public boolean updateApplication(AcceptApplicationDto acceptApplicationDto) {
        Application application = applicationRepository.findById(acceptApplicationDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Application ", "id", String.valueOf(acceptApplicationDto.getId()))
        );
        ApplicationMapper.mapToApplication(acceptApplicationDto, application);
        applicationRepository.save(application);
        return true;
    }

    @Override
    public boolean deleteApplication(int applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow(
                () -> new ResourceNotFoundException("Application", "id", String.valueOf(applicationId))
        );
        applicationRepository.deleteById(application.getId());
        return true;
    }
}

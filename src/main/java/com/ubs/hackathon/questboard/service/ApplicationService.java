package com.ubs.hackathon.questboard.service;

import com.ubs.hackathon.questboard.dto.AcceptApplicationDto;
import com.ubs.hackathon.questboard.dto.ApplicationDto;
import com.ubs.hackathon.questboard.dto.ApplicationsDto;
import com.ubs.hackathon.questboard.dto.CreateApplicationDto;

public interface ApplicationService {

    ApplicationsDto getAllApplicationsForQuest(int questId);

    ApplicationDto getApplication(int questId, int applicationId);

    void createApplication(CreateApplicationDto createApplicationDto);

    boolean updateApplication(AcceptApplicationDto acceptApplicationDto);

    boolean deleteApplication(int applicationId);

}

package com.ubs.hackathon.questboard.controller;

import com.ubs.hackathon.questboard.constants.ApplicationConstants;
import com.ubs.hackathon.questboard.dto.*;
import com.ubs.hackathon.questboard.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApplicationController {

    private ApplicationService applicationService;

    @GetMapping("/quests/{questId}/applications")
    public ResponseEntity<ApplicationsDto> getAllApplicationsForQuest(@PathVariable int questId) {
        ApplicationsDto applicationsDto = applicationService.getAllApplicationsForQuest(questId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(applicationsDto);
    }

    @GetMapping("/quests/{questId}/applications/{applicationId}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable int questId, @PathVariable int applicationId) {
        ApplicationDto applicationDto = applicationService.getApplication(questId, applicationId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(applicationDto);
    }

    @PostMapping("/quests/{questId}/applications")
    public ResponseEntity<ResponseDto> createApplication(@PathVariable int questId, @RequestBody CreateApplicationDto createApplicationDto) {
        createApplicationDto.setQuestId(questId);
        applicationService.createApplication(createApplicationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ApplicationConstants.STATUS_201, ApplicationConstants.MESSAGE_201));
    }

    @PutMapping("/quests/{questId}/applications/{applicationId}")
    public ResponseEntity<ResponseDto> acceptApplication(@PathVariable int questId, @PathVariable int applicationId, @RequestBody AcceptApplicationDto acceptApplicationDto) {
        acceptApplicationDto.setId(applicationId);
        boolean isUpdated = applicationService.updateApplication(acceptApplicationDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ApplicationConstants.STATUS_200, ApplicationConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ApplicationConstants.STATUS_417, ApplicationConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/quests/{questId}/applications/{applicationId}")
    public ResponseEntity<ResponseDto> deleteApplication(@PathVariable int applicationId) {
        boolean isDeleted = applicationService.deleteApplication(applicationId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ApplicationConstants.STATUS_200, ApplicationConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ApplicationConstants.STATUS_417, ApplicationConstants.MESSAGE_417_DELETE));
        }
    }

}

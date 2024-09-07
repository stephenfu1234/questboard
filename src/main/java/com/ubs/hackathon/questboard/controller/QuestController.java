package com.ubs.hackathon.questboard.controller;

import com.ubs.hackathon.questboard.constants.QuestConstants;
import com.ubs.hackathon.questboard.dto.*;
import com.ubs.hackathon.questboard.service.QuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class QuestController {

    private QuestService questService;

    @GetMapping("/quests/sponsor/{userId}")
    public ResponseEntity<QuestsDto> getAllQuestsSponsorView(@PathVariable int userId) {
        QuestsDto questsDto = questService.getAllQuests("sponsor", userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questsDto);
    }

    @GetMapping("/quests/hero/{userId}")
    public ResponseEntity<QuestsDto> getAllQuestsHeroView(@PathVariable int userId) {
        QuestsDto questsDto = questService.getAllQuests("hero", userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questsDto);
    }

    @GetMapping("/quests")
    public ResponseEntity<QuestsDto> getAllQuests(@RequestBody(required=false) ListQuestsDto listQuestsDto) {
        QuestsDto questsDto = questService.getAllQuests(listQuestsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questsDto);
    }

    @GetMapping("/quests/{questId}")
    public ResponseEntity<QuestDto> getQuestById(@PathVariable int questId) {
        QuestDto questDto = questService.getQuest(questId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questDto);
    }

    @PostMapping("/quests")
    public ResponseEntity<ResponseDto> createQuest(@RequestBody CreateQuestDto createQuestDto) {
        questService.createQuest(createQuestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(QuestConstants.STATUS_201, QuestConstants.MESSAGE_201));
    }

    @PutMapping("/quests/{questId}")
    public ResponseEntity<ResponseDto> completeQuest(@PathVariable int questId, @RequestBody CompleteQuestDto completeQuestDto) {
        completeQuestDto.setId(questId);
        boolean isUpdated = questService.updateQuest(completeQuestDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(QuestConstants.STATUS_200, QuestConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(QuestConstants.STATUS_417, QuestConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/quests/{questId}")
    public ResponseEntity<ResponseDto> deleteQuest(@PathVariable int questId) {
        boolean isDeleted = questService.deleteQuest(questId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(QuestConstants.STATUS_200, QuestConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(QuestConstants.STATUS_417, QuestConstants.MESSAGE_417_DELETE));
        }
    }

}

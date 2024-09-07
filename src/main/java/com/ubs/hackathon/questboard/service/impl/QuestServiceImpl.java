package com.ubs.hackathon.questboard.service.impl;

import com.ubs.hackathon.questboard.dto.*;
import com.ubs.hackathon.questboard.entity.Quest;
import com.ubs.hackathon.questboard.entity.UbsUser;
import com.ubs.hackathon.questboard.exception.ResourceNotFoundException;
import com.ubs.hackathon.questboard.mapper.CreateQuestMapper;
import com.ubs.hackathon.questboard.mapper.QuestMapper;
import com.ubs.hackathon.questboard.mapper.QuestsMapper;
import com.ubs.hackathon.questboard.repository.QuestRepository;
import com.ubs.hackathon.questboard.repository.UbsUserRepository;
import com.ubs.hackathon.questboard.service.QuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestServiceImpl implements QuestService {

    private QuestRepository questRepository;
    private UbsUserRepository ubsUserRepository;

    @Override
    public QuestsDto getAllQuests(String role, int userId) {
        List<Quest> quests = questRepository.findAll();

        List<Quest> filteredQuests = quests.stream()
                .filter(quest -> role.equals("sponsor") == quest.getSponsor().getId().equals(userId))
                .collect(Collectors.toList());

        return QuestsMapper.mapToQuestsDto(filteredQuests, new QuestsDto());
    }

    @Override
    public QuestsDto getAllQuests(ListQuestsDto listQuestsDto) {
        List<Quest> quests = questRepository.findAll();

        if(listQuestsDto != null && (!listQuestsDto.getCategory().isEmpty() || !listQuestsDto.getKeyword().isEmpty())) {
            List<Quest> filteredQuests = quests.stream()
                    .filter(quest -> {

                        if(!listQuestsDto.getCategory().isEmpty() && quest.getCategory().equals(listQuestsDto.getCategory())) {
                            return true;
                        }

                        if(!listQuestsDto.getKeyword().isEmpty() && (
                                quest.getCategory().contains(listQuestsDto.getKeyword().toLowerCase()) ||
                                        quest.getSummary().contains(listQuestsDto.getKeyword().toLowerCase()) ||
                                        quest.getTechStack().contains(listQuestsDto.getKeyword().toLowerCase())
                        )) {
                            return true;
                        }

                        return false;
                    })
                    .collect(Collectors.toList());

            return QuestsMapper.mapToQuestsDto(filteredQuests, new QuestsDto());
        }
        return QuestsMapper.mapToQuestsDto(quests, new QuestsDto());
    }

    @Override
    public QuestDto getQuest(int questId) {
        Quest quest = questRepository.findById(questId).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(questId))
        );
        return QuestMapper.mapToQuestDto(quest, new QuestDto());
    }

    @Override
    public void createQuest(CreateQuestDto createQuestDto) {
        Quest quest = new Quest();

        UbsUser ubsUser = ubsUserRepository.findById(createQuestDto.getSponsorId()).orElseThrow(
                () -> new ResourceNotFoundException("UbsUser", "id", String.valueOf(createQuestDto.getSponsorId()))
        );
        CreateQuestMapper.mapToQuest(createQuestDto, quest, ubsUser);
        quest.setStartDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        quest.setStatus("Open");

        questRepository.save(quest);
    }

    @Override
    public boolean updateQuest(CompleteQuestDto completeQuestDto) {
        Quest quest = questRepository.findById(completeQuestDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(completeQuestDto.getId()))
        );
        QuestMapper.mapToQuest(completeQuestDto, quest);

        questRepository.save(quest);
        return true;
    }

    @Override
    public boolean deleteQuest(int questId) {
        Quest quest = questRepository.findById(questId).orElseThrow(
                () -> new ResourceNotFoundException("Quest", "id", String.valueOf(questId))
        );

        questRepository.deleteById(quest.getId());
        return true;
    }
}

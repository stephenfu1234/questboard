package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.QuestDto;
import com.ubs.hackathon.questboard.dto.QuestsDto;
import com.ubs.hackathon.questboard.entity.Quest;

import java.util.List;

public class QuestsMapper {

    public static QuestsDto mapToQuestsDto(List<Quest> quests, QuestsDto questsDto) {
        for(Quest quest: quests) {
            QuestDto questDto = QuestMapper.mapToQuestDto(quest, new QuestDto());
            questsDto.getQuests().add(questDto);
        }
        return questsDto;
    }

}
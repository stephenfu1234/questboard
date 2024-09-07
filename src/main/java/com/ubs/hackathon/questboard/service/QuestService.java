package com.ubs.hackathon.questboard.service;

import com.ubs.hackathon.questboard.dto.*;

public interface QuestService {

    QuestsDto getAllQuests(String role, int userId);

    QuestsDto getAllQuests(ListQuestsDto listQuestsDto);

    QuestDto getQuest(int questId);

    void createQuest(CreateQuestDto createQuestDto);

    boolean updateQuest(CompleteQuestDto completeQuestDto);

    boolean deleteQuest(int questId);

}

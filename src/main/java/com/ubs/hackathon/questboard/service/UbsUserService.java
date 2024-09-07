package com.ubs.hackathon.questboard.service;

import com.ubs.hackathon.questboard.dto.QuestDto;
import com.ubs.hackathon.questboard.dto.QuestsDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.dto.UpdateUbsUserDto;

public interface UbsUserService {

    UbsUserDto getUbsUser(int userId);

    boolean updateUbsUser(UpdateUbsUserDto updateUbsUserDto);

}

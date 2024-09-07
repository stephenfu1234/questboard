package com.ubs.hackathon.questboard.mapper;

import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.dto.UpdateUbsUserDto;
import com.ubs.hackathon.questboard.entity.UbsUser;

public class UbsUserMapper {

    public static UbsUserDto mapToUbsUserDto(UbsUser ubsUser, UbsUserDto ubsUserDto) {
        ubsUserDto.setId(ubsUser.getId());
        ubsUserDto.setGpn(ubsUser.getGpn());
        ubsUserDto.setName(ubsUser.getName());
        ubsUserDto.setEmail(ubsUser.getEmail());
        ubsUserDto.setExpertise(ubsUser.getExpertise());

        return ubsUserDto;
    }

    public static UbsUser mapToUbsUser(UbsUserDto ubsUserDto, UbsUser ubsUser) {
        ubsUser.setId(ubsUserDto.getId());
        ubsUser.setGpn(ubsUserDto.getGpn());
        ubsUser.setName(ubsUserDto.getName());
        ubsUser.setEmail(ubsUserDto.getEmail());
        ubsUser.setExpertise(ubsUserDto.getExpertise());

        // don't overwrite password or role

        return ubsUser;
    }

    public static UbsUser mapToUbsUser(UpdateUbsUserDto updateUbsUserDto, UbsUser ubsUser) {
        ubsUser.setExpertise(updateUbsUserDto.getExpertise());
        return ubsUser;
    }

}
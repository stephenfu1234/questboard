package com.ubs.hackathon.questboard.service.impl;

import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.dto.UpdateUbsUserDto;
import com.ubs.hackathon.questboard.entity.UbsUser;
import com.ubs.hackathon.questboard.exception.ResourceNotFoundException;
import com.ubs.hackathon.questboard.mapper.UbsUserMapper;
import com.ubs.hackathon.questboard.repository.UbsUserRepository;
import com.ubs.hackathon.questboard.service.UbsUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UbsUserServiceImpl implements UbsUserService {

    private UbsUserRepository ubsUserRepository;

    @Override
    public UbsUserDto getUbsUser(int userId) {
        UbsUser ubsUser = ubsUserRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("UbsUser", "id", String.valueOf(userId))
        );
        return UbsUserMapper.mapToUbsUserDto(ubsUser, new UbsUserDto());
    }

    @Override
    public boolean updateUbsUser(UpdateUbsUserDto updateUbsUserDto) {
        UbsUser ubsUser = ubsUserRepository.findById(updateUbsUserDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("UbsUser", "id", String.valueOf(updateUbsUserDto.getId()))
        );
        UbsUserMapper.mapToUbsUser(updateUbsUserDto, ubsUser);

        ubsUserRepository.save(ubsUser);
        return true;
    }

}

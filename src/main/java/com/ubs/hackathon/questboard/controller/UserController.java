package com.ubs.hackathon.questboard.controller;

import com.ubs.hackathon.questboard.constants.QuestConstants;
import com.ubs.hackathon.questboard.dto.ResponseDto;
import com.ubs.hackathon.questboard.dto.UbsUserDto;
import com.ubs.hackathon.questboard.dto.UpdateUbsUserDto;
import com.ubs.hackathon.questboard.service.UbsUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private UbsUserService ubsUserService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UbsUserDto> getUserById(@PathVariable int userId) {
        UbsUserDto ubsUserDto = ubsUserService.getUbsUser(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ubsUserDto);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable int userId, @RequestBody UpdateUbsUserDto updateUbsUserDto) {
        updateUbsUserDto.setId(userId);
        boolean isUpdated = ubsUserService.updateUbsUser(updateUbsUserDto);
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

}

package com.ubs.hackathon.questboard.controller;

import com.ubs.hackathon.questboard.dto.LeaderboardDto;
import com.ubs.hackathon.questboard.service.LeaderboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LeaderboardController {

    private LeaderboardService leaderboardService;

    @GetMapping("/leaderboard")
    public ResponseEntity<LeaderboardDto> getLeaderboard() {
        LeaderboardDto leaderboardDto = leaderboardService.getLeaderboard();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(leaderboardDto);
    }

}

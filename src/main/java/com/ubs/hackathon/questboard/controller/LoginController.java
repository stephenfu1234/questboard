package com.ubs.hackathon.questboard.controller;

import com.ubs.hackathon.questboard.service.QuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/api/v1")
public class LoginController {

    @PostMapping("/signin")
    public String signin() {
        return "signin";
    }

}

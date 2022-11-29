package com.example.smuwebproject.web;

import com.example.smuwebproject.domain.service.UserService;
import com.example.smuwebproject.web.dto.UserSignUpRequestDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class WebController {

    private final UserService userService;


    @GetMapping("/user/signUp")
    private String signUpPage() {
        return "signUp";
    }

    @PostMapping("/user/signUp")
    private String postTest(@Valid UserSignUpRequestDTO userSignUpRequestDTO) {

        log.info("확인");
        userService.signUp(userSignUpRequestDTO.toEntity());

        return "redirect:/";
    }

    @GetMapping("/success")
    private String success() {
        return "result";
    }

    @GetMapping("/posts/save")
    private String postSave() {
        return "posts-save";
    }
}

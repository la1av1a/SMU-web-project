package com.example.smuwebproject;

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

    @GetMapping("/")
    private String test() {
        return "index";
    }

    @PostMapping("/user/signIn")
    private void postTest(@Valid UserSignUpRequestDTO userSignUpRequestDTO) {
        log.info("ID : {}", userSignUpRequestDTO.getUserId());
        log.info("password : {}", userSignUpRequestDTO.getUserPw());
        log.info("name : {}", userSignUpRequestDTO.getUserName());

        userService.signUp(userSignUpRequestDTO.toEntity());
    }

    @GetMapping("/success")
    private String success() {
        return "result";
    }

    @GetMapping("/postSave")
    private String postSave() {
        return "posts-save";
    }
}

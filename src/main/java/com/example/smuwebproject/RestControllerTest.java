package com.example.smuwebproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTest {

    @GetMapping("/aa")
    private String test() {
        return "testzz";
    }
}

package com.example.smuwebproject.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDTO {

    private Long id;
    private String title;
    private String content;
    private String author;
    private int view;
}

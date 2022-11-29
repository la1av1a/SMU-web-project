package com.example.smuwebproject.web.dto;

import com.example.smuwebproject.domain.entity.post.Post;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostListResponseDTO {

    private final Long id;

    private final String title;

    private final String content;

    private final String author;

    private final int view;

    private final Date modifiedDate;

    @Builder
    public PostListResponseDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor().getUserName();
        this.view = post.getView();
        this.modifiedDate = post.getModifiedDate();
    }
}

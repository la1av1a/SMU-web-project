package com.example.smuwebproject.domain.service;

import com.example.smuwebproject.domain.entity.post.Post;
import com.example.smuwebproject.domain.entity.post.PostRepository;
import com.example.smuwebproject.web.dto.PostListResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostListResponseDTO> getPosts(Pageable pageable) {

        Page<Post> posts = postRepository.findAll(pageable);

        return posts.getContent().stream().map(PostListResponseDTO::new)
            .collect(Collectors.toList());
    }
}
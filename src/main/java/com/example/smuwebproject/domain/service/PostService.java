package com.example.smuwebproject.domain.service;

import com.example.smuwebproject.config.security.UserDetailsImpl;
import com.example.smuwebproject.domain.entity.post.Post;
import com.example.smuwebproject.domain.entity.post.PostRepository;
import com.example.smuwebproject.web.dto.PostRequestDTO;
import com.example.smuwebproject.web.dto.PostResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getPosts(Pageable pageable) {

        Page<Post> posts = postRepository.findAll(pageable);

        return posts.getContent().stream().map(PostResponseDTO::new)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostResponseDTO getPost(Long id) {
        Post post = findPostById(id);
        return PostResponseDTO.builder()
            .post(post)
            .build();
    }

    @Transactional(readOnly = false)
    public void updatePost(UserDetailsImpl userDetails, Long id, PostRequestDTO postRequestDTO) {
        Post post = findPostById(id);
        log.info("title : {} ", postRequestDTO.getTitle());
        log.info("content : {} ", postRequestDTO.getContent());
        try {
            invalidCheck(userDetails, post);
            post.setTitle(postRequestDTO.getTitle());
            post.setContent(postRequestDTO.getContent());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void delete(UserDetailsImpl userDetails, Long id) {
        Post post = findPostById(id);
        try {
            invalidCheck(userDetails, post);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        deletePost(post);
    }

    private void deletePost(Post post) {
        postRepository.delete(post);
    }


    private Post findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    private void invalidCheck(UserDetailsImpl userDetails, Post post)
        throws IllegalAccessException {
        if (userDetails.getUserId().equals(post.getAuthor().getUserId())) {
            return;
        }

        throw new IllegalAccessException();
    }
}
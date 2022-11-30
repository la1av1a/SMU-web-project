package com.example.smuwebproject.web;

import com.example.smuwebproject.domain.service.PostService;
import com.example.smuwebproject.web.dto.PostListResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    private String test(@PageableDefault() Pageable pageable,
        Model model) {

        List<PostListResponseDTO> postList = postService.getPosts(pageable);
        model.addAttribute("postList", postList);
        return "index";
    }
}

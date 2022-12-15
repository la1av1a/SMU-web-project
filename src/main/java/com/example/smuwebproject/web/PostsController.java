package com.example.smuwebproject.web;

import com.example.smuwebproject.domain.service.PostService;
import com.example.smuwebproject.web.dto.PostResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostService postService;

    @GetMapping("/")
    private String test(
        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
        Model model) {

        List<PostResponseDTO> postList = postService.getPosts(pageable);
        model.addAttribute("postList", postList);
        return "index";
    }


}

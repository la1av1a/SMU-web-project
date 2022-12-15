package com.example.smuwebproject.web;

import com.example.smuwebproject.config.security.UserDetailsImpl;
import com.example.smuwebproject.domain.service.PostService;
import com.example.smuwebproject.domain.service.UserService;
import com.example.smuwebproject.web.dto.PostRequestDTO;
import com.example.smuwebproject.web.dto.PostResponseDTO;
import com.example.smuwebproject.web.dto.UserSignUpRequestDTO;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Slf4j
@Controller
public class WebController {

    private final UserService userService;
    private final PostService postService;

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

    @GetMapping("/posts/save")
    private String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/{id}")
    private String getPost(@PathVariable("id") Long id, Model model) {
        PostResponseDTO postResponseDTO = postService.getPost(id);

        model.addAttribute("post", postResponseDTO);
        return "posts-read";
    }

    @GetMapping("/posts/update/{id}")
    private String updatePage(@PathVariable("id") Long id, Model model) {
        PostResponseDTO postResponseDTO = postService.getPost(id);
        model.addAttribute("post", postResponseDTO);
        return "posts-update";
    }

    @PostMapping("/posts/update/{id}")
    private String updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @PathVariable("id") Long id,
        PostRequestDTO requestDTO) {
        postService.updatePost(userDetails, id, requestDTO);

        return "redirect:/posts/{id}";
    }

    @PostMapping("/posts/delete/{id}")
    private String deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails,
        @PathVariable("id") Long id) {
        postService.delete(userDetails, id);

        return "redirect:/";
    }

    @GetMapping("/success")
    private String success() {
        return "result";
    }

    @GetMapping("/posts")
    private String getBoard(
        @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
        @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
        Model model) {
        PageRequest pageRequest = PageRequest.of(page, size);
        List<PostResponseDTO> postResponseDTOList = postService.getPosts(pageRequest);
        model.addAttribute("postList", postResponseDTOList);
        return "index";
    }

}

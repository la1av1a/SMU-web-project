package com.example.smuwebproject.domain.service;


import com.example.smuwebproject.domain.entity.user.User;
import com.example.smuwebproject.domain.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signUp(User user) {

        userRepository.save(user);
    }
}

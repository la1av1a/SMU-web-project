package com.example.smuwebproject.config.security;

import com.example.smuwebproject.domain.entity.user.User;
import com.example.smuwebproject.domain.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(userId).orElseThrow(
            () -> new UsernameNotFoundException("유저를 찾을 수 없습니다"));

        log.info("로그인 성공 id : {}", user.getUserId());

        return UserDetailsImpl.builder()
            .userId(user.getUserId())
            .userPw(passwordEncoder.encode(user.getUserPw()))
            .userName(user.getUserName())
            .role(Role.ROLE_USER)
            .build();
    }
}

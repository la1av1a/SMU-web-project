package com.example.smuwebproject.web.dto;

import com.example.smuwebproject.domain.entity.user.User;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpRequestDTO {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String userPw;

    @NotEmpty
    private String userName;

    public User toEntity() {
        return User.builder()
            .userId(userId)
            .userPw(userPw)
            .userName(userName)
            .build();
    }
}

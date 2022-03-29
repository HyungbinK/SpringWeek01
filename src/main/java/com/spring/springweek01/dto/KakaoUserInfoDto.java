package com.spring.springweek01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;
    }


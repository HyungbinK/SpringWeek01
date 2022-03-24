package com.spring.springweek01.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardRequestDto {
    private String username;
    private String title;
    private String contents;
}

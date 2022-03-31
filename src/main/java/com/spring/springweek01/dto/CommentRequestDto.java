package com.spring.springweek01.dto;

import com.spring.springweek01.model.Board;
import com.spring.springweek01.model.User;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentRequestDto {
    private String comment;
//    private Long boardId;
}

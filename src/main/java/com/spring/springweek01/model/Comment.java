package com.spring.springweek01.model;

import com.spring.springweek01.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends TimeStamped {

    //댓글의 ID
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;
//
//    //게시글 번호
//    @Column(nullable = false)
//    private Long boardId;

//    @Column(nullable = false)
//    private Long userId;

    public Comment(CommentRequestDto commentRequestDto, String username) {
//        this.userId = userId;
        this.comment = commentRequestDto.getComment();
//        this.boardId = commentRequestDto.getBoardId();
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

//    public void updateComment(CommentRequestDto requestDto) {
//        this.comment = requestDto.getComment();
//    }

}


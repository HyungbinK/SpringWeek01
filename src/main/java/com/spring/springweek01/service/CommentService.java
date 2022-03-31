package com.spring.springweek01.service;

import com.spring.springweek01.dto.CommentRequestDto;
import com.spring.springweek01.model.Comment;
import com.spring.springweek01.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

//    @Transactional
//    public void updateComment(Long commentId, CommentRequestDto requestDto){
//        Comment comment = commentRepository.findById(commentId).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        comment.updateComment(requestDto);
//    }
}

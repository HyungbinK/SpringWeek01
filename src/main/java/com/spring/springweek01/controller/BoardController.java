package com.spring.springweek01.controller;

import com.spring.springweek01.model.Board;
import com.spring.springweek01.repository.BoardRepository;
import com.spring.springweek01.dto.BoardRequestDto;
import com.spring.springweek01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    //게시글 전체 조회
    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    // 특정 게시글 조회
    @GetMapping("/api/details/{id}")
    public Board getDetail (@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null"));
    }

    //게시글 작성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }

//    @PutMapping("/api/boards/{id}")
//    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
//        boardService.update(id, requestDto);
//        return id;
//    }
//
//    @DeleteMapping("/api/boards/{id}")
//    public Long deleteBoard(@PathVariable Long id) {
//        boardRepository.deleteById(id);
//        return id;
//    }
}
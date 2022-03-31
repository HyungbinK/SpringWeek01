package com.spring.springweek01.controller;

import com.spring.springweek01.dto.BoardRequestDto;
import com.spring.springweek01.model.Board;
import com.spring.springweek01.repository.BoardRepository;
import com.spring.springweek01.security.UserDetailsImpl;
import com.spring.springweek01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    //게시글 전체 조회
    @ResponseBody
    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/details/{id}")
    public String board(){
        return "detail";
    }

    // 특정 게시글 조회
    @ResponseBody
    @GetMapping("/api/details/{id}")
    public Board getDetail(@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null"));
    }

    //게시글 생성 페이지 이동
    @GetMapping("/post")
    public ModelAndView write() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post.html");
        return modelAndView;
    }

    //게시글 작성
    @ResponseBody
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
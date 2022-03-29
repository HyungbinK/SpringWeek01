package com.spring.springweek01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.springweek01.dto.SignupRequestDto;
import com.spring.springweek01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired //1주차에서 di를 받는 부분(?)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지 >> 이게 왜 기본페이지로 설정되지..?
    @GetMapping("/user/login")
    public String login() {
        return "login"; //login만 보내주면 타임리프가 경로 및 .html 추가
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid SignupRequestDto requestDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("requestDto", requestDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
        }
        // 중복 검사 후 메세지
        try { userService.registerUser(requestDto); }
        catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signup"; }

            return "redirect:/user/login";

    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        // authorizedCode: 카카오 서버로부터 받은 인가 코드
        userService.kakaoLogin(code);

        return "redirect:/";
    }
}

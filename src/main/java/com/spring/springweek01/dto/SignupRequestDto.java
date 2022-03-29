package com.spring.springweek01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank(message="닉네임은 필수 입력 값입니다.")
    @Size(min = 3, message = "3글자 이상 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{4,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 4자 ~ 20자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String checkpw;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;
}
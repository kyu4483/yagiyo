package com.kh.yagiyo.web.form.member;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class JoinForm {
  private Long id;

  private String pw;

  private String nick;

  @Email
  private String email;

  private String gender;

  private int age;

}

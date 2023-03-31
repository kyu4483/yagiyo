package com.kh.yagiyo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
      private long id;
  private String pw;
  private String nick;
  private String email;
  private String gender;
  private int age;
  private String gubun;
}

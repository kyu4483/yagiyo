package com.kh.yagiyo.web;

import com.kh.yagiyo.domain.entity.Member;
import com.kh.yagiyo.domain.member.svc.MemberSVC;
import com.kh.yagiyo.web.form.member.JoinForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/Members")
public class MemberController {

  private final MemberSVC memberSVC;

  //회원가입양식
  @GetMapping("/add")
  public String joinForm(Model model) {
    model.addAttribute("joinForm", new JoinForm());
    return "member/joinForm";
  }
}

  //회원가입 처리



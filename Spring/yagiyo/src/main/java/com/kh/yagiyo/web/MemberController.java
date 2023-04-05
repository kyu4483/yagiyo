package com.kh.yagiyo.web;

import com.kh.yagiyo.domain.entity.Member;
import com.kh.yagiyo.domain.member.svc.MemberSVC;
import com.kh.yagiyo.web.form.member.JoinForm;
import com.kh.yagiyo.web.form.member.agreeForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberSVC memberSVC;

  @GetMapping("agree")
  public String agreeForm(Model model){
    model.addAttribute("agreeForm",new agreeForm());
    return "/member/Agree";
  }

  //회원가입양식
  @GetMapping("add")
  public String joinForm(Model model){
    model.addAttribute("joinForm",new JoinForm());
    return "/member/joinForm";
  }



  //회원가입처리
  @PostMapping("add")
  public String join(@Valid @ModelAttribute JoinForm joinForm, BindingResult bindingResult){
    log.info("joinForm={}",joinForm);
    if(bindingResult.hasErrors()){
      log.info("bindingResult={}",bindingResult);
      return "/member/joinForm";
    }

    //비밀번호 체크
    if(!joinForm.getPw().equals(joinForm.getPw_check())) {
      bindingResult.reject("pw","비밀번호가 동일하지 않습니다.");
      log.info("bindingResult={}",bindingResult);
      return "/member/joinForm";
    }

    Member member = new Member();
    member.setId(joinForm.getId());
    member.setPw(joinForm.getPw());
    member.setEmail(joinForm.getEmail());
    member.setNick(joinForm.getNick());
    member.setGender(joinForm.getGender());
    member.setAge(joinForm.getAge());

    memberSVC.save(member);
    return "/member/joinSuccess";
  }


}




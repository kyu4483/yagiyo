package com.kh.yagiyo.domain.member.dao;

import com.kh.yagiyo.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor

public class MemberDAOImpl implements MemberDAO{
  private final NamedParameterJdbcTemplate template;
  @Override
  //등록

  public Member save(Member member) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into member ( ");
    sql.append("    id, ");
    sql.append("    pw, ");
    sql.append("    nick, ");
    sql.append("    email, ");
    sql.append("    gender, ");
    sql.append("    age, ");
    sql.append(") values( ");
    sql.append("    id_seq.nextval, ");
    sql.append("    :pw, ");
    sql.append("    :nick, ");
    sql.append("    :email, ");
    sql.append("    :gender, ");
    sql.append("    :age, ");
    sql.append(") ");

    SqlParameterSource param = new BeanPropertySqlParameterSource(member);
    KeyHolder keyHolder = new GeneratedKeyHolder(); //insert된 레코드에서 컬럼값추출
    template.update(sql.toString(),param,keyHolder,new String[]{"id"});

    long id = keyHolder.getKey().longValue();

    member.setId(id);
    return member;
  }

  @Override
  public void update(Long id, Member member) {

  }

  @Override
  public Optional<Member> findByEmail(String email) {
    return Optional.empty();
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Member> findAll() {
    return null;
  }

  @Override
  public void delete(String email) {

  }

  @Override
  public boolean isExist(String email) {
    return false;
  }

  @Override
  public Optional<Member> login(String email, String pw) {
    return Optional.empty();
  }

  @Override
  public Optional<String> findEmailByNickname(String nick) {
    return Optional.empty();
  }
}

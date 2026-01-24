package com.example.demo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.MemberRequest;
import com.example.demo.model.Member;
import com.example.demo.rowmapper.MemberRowMapper;


@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createMember(MemberRequest memberRequest) {
        String sql = "INSERT INTO member (membername, gender, birthday, email, phone, country, creditcard, status) "
                   + "VALUES (:membername, :gender, :birthday, :email, :phone, :country, :creditcard, :status)";


        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("membername", memberRequest.getMemberName());
        params.addValue("gender", memberRequest.getMemberGender());
        params.addValue("birthday", memberRequest.getMemberBirthday());
        params.addValue("email", memberRequest.getMemberEmail());
        params.addValue("phone", memberRequest.getMemberPhone());
        params.addValue("country", memberRequest.getMemberCountry());
        params.addValue("creditcard", memberRequest.getMemberCreditcard());
        params.addValue("status", "ACTIVE");


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, params, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to retrieve generated key for employee");
        }

        return key.intValue();
        }

    @Override
    public Member getMemberById(Integer memberId) {
        String sql = "SELECT idmember, membername, gender, birthday, email, phone, country, creditcard, status FROM member WHERE idmember = :memberId";

        Map<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);

        List<Member> list = namedParameterJdbcTemplate.query(sql, params, new MemberRowMapper());

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Member> getAllMember() {
        String sql = "SELECT idmember, membername, gender, birthday, email, phone, country, creditcard, status FROM member";

        return namedParameterJdbcTemplate.query(sql, new MemberRowMapper());
    }

    @Override
    public void updateMember(Integer memberId, MemberRequest memberRequest) {
        String sql = "UPDATE member SET membername = :membername, gender = :gender, birthday = :birthday, email = :email, phone = :phone, country = :country, creditcard = :creditcard WHERE idmember = :memberId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("membername", memberRequest.getMemberName());
        params.addValue("gender", memberRequest.getMemberGender());
        params.addValue("birthday", memberRequest.getMemberBirthday());
        params.addValue("email", memberRequest.getMemberEmail());
        params.addValue("phone", memberRequest.getMemberPhone());
        params.addValue("country", memberRequest.getMemberCountry());
        params.addValue("creditcard", memberRequest.getMemberCreditcard());
        params.addValue("memberId", memberId);

        namedParameterJdbcTemplate.update(sql, params);
    }
}
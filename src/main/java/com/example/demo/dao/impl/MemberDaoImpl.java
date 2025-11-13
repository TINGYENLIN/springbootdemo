package com.example.demo.dao.impl;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.MemberRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer createMember(MemberRequest memberRequest) {
        String sql = "INSERT INTO member (memberename, gender, birthday, email, phone, country, creditcard, status) "
                   + "VALUES (:memberename, :gender, :birthday, :email, :phone, :country, :creditcard, :status)";


        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("membername", memberRequest.getMemberName());
        params.addValue("gender", memberRequest.getMemberGender());
        params.addValue("birthday", memberRequest.getMemberBirthday());
        params.addValue("email", memberRequest.getMemberEmail());
        params.addValue("phone", memberRequest.getMemberPhone());
        params.addValue("country", memberRequest.getMemberCountry());
        params.addValue("creditcard", memberRequest.getMemberCreditcard());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, params, keyHolder);

        Number key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to retrieve generated key for employee");
        }

        return key.intValue();
        }
}

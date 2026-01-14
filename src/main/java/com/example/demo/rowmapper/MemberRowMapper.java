package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import com.example.demo.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    @NonNull
    public Member mapRow(@NonNull ResultSet resultSet, int i) throws SQLException {
        Member member = new Member();    

        member.setMemberId(resultSet.getInt("idmember"));
        member.setMemberName(resultSet.getString("membername"));
        member.setMemberGender(resultSet.getString("gender"));
        member.setMemberBirthday(resultSet.getString("birthday"));
        member.setMemberEmail(resultSet.getString("email"));
        member.setMemberPhone(resultSet.getString("phone"));
        member.setMemberCountry(resultSet.getString("country"));
        member.setMemberCreditcard(resultSet.getString("creditcard"));
        member.setStatus(resultSet.getString("status"));

        return member;
    }
}

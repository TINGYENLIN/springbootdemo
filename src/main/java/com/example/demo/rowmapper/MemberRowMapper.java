package com.example.demo.rowmapper;

import com.example.demo.model.Member;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper<Member> {

    @Override
    @NonNull
    public Member mapRow(@NonNull ResultSet resultSet, int i) throws SQLException {
        Member member = new Member();    

        member.setMemberId(resultSet.getInt("idememner"));
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

package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.MemberRequest;
import com.example.demo.model.Member;

public interface MemberDao {

    Integer createMember(MemberRequest memberRequest);
    Member getMemberById(Integer memberId);
    List<Member> getAllMember();
}

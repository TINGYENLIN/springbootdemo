package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MemberRequest;
import com.example.demo.model.Member;

public interface MemberService {

    Integer createMember(MemberRequest memberRequest);
    
    Member getMemberById(Integer memberId);
    
    List<Member> getAllMember();

    void updateMember(Integer memberId, MemberRequest memberRequest);
}

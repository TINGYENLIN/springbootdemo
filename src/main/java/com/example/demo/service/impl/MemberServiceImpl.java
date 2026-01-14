package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.MemberRequest;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;


@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    @Override
    public Integer createMember(MemberRequest memberRequest) {
        return memberDao.createMember(memberRequest);
    }

    @Override
    public Member getMemberById(Integer memberId) {
        return memberDao.getMemberById(memberId);
    }

    @Override
    public List<Member> getAllMember() {
        return memberDao.getAllMember();
    }
}

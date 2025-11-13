package com.example.demo.service.impl;

import com.example.demo.dao.MemberDao;
import com.example.demo.dto.MemberRequest;
import com.example.demo.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    @Override
    public Integer createMember(MemberRequest memberRequest) {
        return memberDao.createMember(memberRequest);
    }
}

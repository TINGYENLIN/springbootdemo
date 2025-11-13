package com.example.demo.dao;

import com.example.demo.dto.MemberRequest;

public interface MemberDao {

    Integer createMember(MemberRequest memberRequest);
}

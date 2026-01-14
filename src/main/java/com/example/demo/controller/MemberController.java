package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberRequest;
import com.example.demo.model.Member;
import com.example.demo.service.MemberService;


@RestController
@CrossOrigin(origins = "*") // 允許所有來源
public class MemberController {

    @Autowired
    private MemberService memberService;


    // 新增會員
    @PostMapping("/members")
    public ResponseEntity<String> createMember(@RequestBody MemberRequest memberRequest) {
        Integer memberId = memberService.createMember(memberRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Member created with ID: " + memberId);
    }

    // 取得所有會員列表 (返回 JSON 格式)
    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMember() {
        List<Member> members = memberService.getAllMember();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    // 根據 ID 取得單一會員
    @GetMapping("/members/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Integer memberId) {
        Member member = memberService.getMemberById(memberId);
        if (member != null) {
            return ResponseEntity.status(HttpStatus.OK).body(member);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

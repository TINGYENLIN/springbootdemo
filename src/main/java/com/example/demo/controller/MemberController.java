package com.example.demo.controller;

import com.example.demo.dto.MemberRequest;
import com.example.demo.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    // 新增員工
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody MemberRequest memberRequest) {
        Integer memberId = memberService.createMember(memberRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Member created with ID: " + memberId);
    }
}

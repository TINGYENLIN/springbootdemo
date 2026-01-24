package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class MemberRequest {

    @NotNull
    private Integer memberId;

    @NotNull
    private String memberName;

    @NotNull
    private String memberGender;

    @NotNull
    private String memberBirthday;

    @NotNull
    private String memberEmail;

    @NotNull
    private String memberPhone;

    @NotNull
    private String memberCountry;

    @NotNull
    private String memberCreditcard;


    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(String memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberCountry() {
        return memberCountry;
    }

    public void setMemberCountry(String memberCountry) {
        this.memberCountry = memberCountry;
    }

    public String getMemberCreditcard() {
        return memberCreditcard;
    }

    public void setMemberCreditcard(String memberCreditcard) {
        this.memberCreditcard = memberCreditcard;
    }
}

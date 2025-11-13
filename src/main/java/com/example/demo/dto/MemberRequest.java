package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class MemberRequest {

    @NotNull
    private String membername;

    @NotNull
    private String membergender;

    @NotNull
    private String memberbirthday;

    @NotNull
    private String memberemail;

    @NotNull
    private String memberphone;

    @NotNull
    private String membercountry;

    @NotNull
    private String membercreditcard;


    public String getMemberName() {
        return membername;
    }

    public void setEmployeeName(String membername) {
        this.membername = membername;
    }

    public String getMemberGender() {
        return membergender;
    }

    public void setMemberGender(String membergender) {
        this.membergender = membergender;
    }

    public String getMemberBirthday() {
        return memberbirthday;
    }

    public void setMemberBirthday(String memberbirthday) {
        this.memberbirthday = memberbirthday;
    }

    public String getMemberEmail() {
        return memberemail;
    }

    public void setMemberEmail(String memberemail) {
        this.memberemail = memberemail;
    }

    public String getMemberPhone() {
        return memberphone;
    }

    public void setMemberPhone(String memberphone) {
        this.memberphone = memberphone;
    }

    public String getMemberCountry() {
        return membercountry;
    }

    public void setMemberCountry(String membercountry) {
        this.membercountry = membercountry;
    }

    public String getMemberCreditcard() {
        return membercreditcard;
    }

    public void setMemberCreditcard(String membercreditcard) {
        this.membercreditcard = membercreditcard;
    }
}

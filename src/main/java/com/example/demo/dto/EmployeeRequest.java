package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {

    @NotNull
    private String employeename;

    @NotNull
    private String employeegender;

    @NotNull
    private String employeebirthday;

    @NotNull
    private String employeephone;

    private String remark;


    public String getEmployeeName() {
        return employeename;
    }

    public void setEmployeeName(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeeGender() {
        return employeegender;
    }

    public void setEmployeeGender(String employeegender) {
        this.employeegender = employeegender;
    }

    public String getEmployeeBirthday() {
        return employeebirthday;
    }

    public void setEmployeeBirthday(String employeebirthday) {
        this.employeebirthday = employeebirthday;
    }

    public String getEmployeePhone() {
        return employeephone;
    }

    public void setEmployeePhone(String employeephone) {
        this.employeephone = employeephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}


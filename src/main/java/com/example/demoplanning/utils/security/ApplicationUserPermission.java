package com.example.demoplanning.utils.security;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ApplicationUserPermission {
    GENERATE_PLANNING("plannng:write"),
    READ_PLANNING("planning:read"),
    EMPLOYEE_WRITE("employee:write"),
    EMPLOYEE_READ("employee:read"),
    REPORT_WRITE("report:write");

    private final String permission;
    public String getPermission(){return permission;}



}

package com.example.hospitalsystemmanagement.entity;

public enum RoleType {
    ADMIN(1), USER(2), NURSE(3), PATIENT(4), DOCTOR(5);
    private int roleId;

    RoleType(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}

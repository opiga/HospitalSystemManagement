package com.boots.entity;

public enum RoleType {
    USER(1), ADMIN(2);
    private int roleId;

    RoleType(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}

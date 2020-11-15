package com.sda.onlinestore.dto;

public class RoleDTO {

    private String roleName;

    public RoleDTO(String roleName) {
        this.roleName = roleName;
    }

    public RoleDTO() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

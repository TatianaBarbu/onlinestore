package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.Address;
import com.sda.onlinestore.enums.PreferredChannel;
import com.sda.onlinestore.entity.Role;

public class UserAccountDto {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private AddressDto address;
    private Role role;
    private String thumbnail;
    private PreferredChannel preferredChannel;

    public UserAccountDto(String email, String password, String thumbnail, String confirmPassword, String username) {
        this.email = email;
        this.password = password;
        this.thumbnail = thumbnail;
        this.confirmPassword = confirmPassword;
        this.username = username;
    }

    public UserAccountDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}

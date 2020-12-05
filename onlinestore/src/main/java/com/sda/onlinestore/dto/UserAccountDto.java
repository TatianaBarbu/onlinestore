package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.Address;
import com.sda.onlinestore.enums.PreferredChannel;
import com.sda.onlinestore.entity.Role;
import com.sda.onlinestore.enums.PreferredChannel;

import javax.persistence.*;

public class UserAccountDto {

    private int id;
    private String email;
    private String password;
    private String confirmPassword;
    private String city;
    private AddressDto address;
    private Role role;
    private String thumbnail;
    private PreferredChannel preferredChannel;

    public UserAccountDto(String email, String password, String city, String thumbnail, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.city = city;
        this.thumbnail = thumbnail;
        this.confirmPassword = confirmPassword;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

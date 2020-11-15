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
    private String city;
    private Address address;
    private Role role;
    private String thumbnail;
    private PreferredChannel preferredChannel;

    public UserAccountDto(String email, String password, String city, String thumbnail) {
        this.email = email;
        this.password = password;
        this.city = city;
        this.thumbnail = thumbnail;
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
}

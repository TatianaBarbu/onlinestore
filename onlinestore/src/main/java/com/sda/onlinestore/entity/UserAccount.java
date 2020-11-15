package com.sda.onlinestore.entity;

import com.sda.onlinestore.enums.PreferredChannel;

import javax.persistence.*;


@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String city;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;

    private String thumbnail;

    @Enumerated(EnumType.STRING)
    private PreferredChannel preferredChannel;


    public UserAccount() {
    }

    public UserAccount(String email, String password, String city, Address address, Role role, String thumbnail, PreferredChannel preferredChannel) {
        this.email = email;
        this.password = password;
        this.city = city;
        this.address = address;
        this.role = role;
        this.thumbnail = thumbnail;
        this.preferredChannel = preferredChannel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogoType() {
        return thumbnail;
    }

    public void setLogoType(String logoType) {
        this.thumbnail = thumbnail;
    }

    public PreferredChannel getPreferredChannel() {
        return preferredChannel;
    }

    public void setPreferredChannel(PreferredChannel preferredChannel) {
        this.preferredChannel = preferredChannel;
    }
}
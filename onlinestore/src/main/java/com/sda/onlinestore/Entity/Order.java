package com.sda.onlinestore.entity;

import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalCost;
    private String deliveryAddress;
    private String userAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfOrder;


    //OrderLine
    //Customer
    //Status
    public Order(double totalCost, String deliveryAddress, String userAddress, Date dateOfOrder) {
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfOrder = dateOfOrder;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}

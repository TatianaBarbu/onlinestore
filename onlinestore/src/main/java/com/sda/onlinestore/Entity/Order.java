package com.sda.onlinestore.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany
    private List<OrderLine> orderLine;

    @OneToOne
    private UserAccount userAccount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(double totalCost, String deliveryAddress, String userAddress, Date dateOfOrder, List<OrderLine> orderLine, UserAccount userAccount, OrderStatus orderStatus) {
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfOrder = dateOfOrder;
        this.orderLine = orderLine;
        this.userAccount = userAccount;
        this.orderStatus = orderStatus;
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

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine) {
        this.orderLine = orderLine;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
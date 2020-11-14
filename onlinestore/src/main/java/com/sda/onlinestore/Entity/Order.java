package com.sda.onlinestore.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order {

    @Id
   private String id;
    private double totalCost;
    private String deliveryAdress;
    private String userAdress;
    private Date dateOfOrder;







}

package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.OrderDto;
import com.sda.onlinestore.entity.Order;
import com.sda.onlinestore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setTotalCost(orderDto.getTotalCost());
        order.setDeliveryAddress(orderDto.getDeliveryAddress());
        order.setDateOfOrder(orderDto.getDateOfOrder());
        //order lines
        //user account    ??
        //order status
        orderRepository.save(order);
    }

    public List<OrderDto> getOrders(){
        List<Order> orderList = orderRepository.findAll();

        List<OrderDto> orderDtoList = new ArrayList<>();

        for(Order order: orderList){
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setTotalCost(order.getTotalCost());
            orderDto.setDeliveryAddress(order.getDeliveryAddress());
            orderDto.setDateOfOrder(order.getDateOfOrder());
        }
        return orderDtoList;
    }

}

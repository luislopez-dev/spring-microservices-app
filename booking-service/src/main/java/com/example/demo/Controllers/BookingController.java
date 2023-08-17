package com.example.demo.Controllers;

import com.example.demo.Clients.StockClient;
import com.example.demo.DTOs.OrderDTO;
import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockClient stockClient;

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallbackToStockService")
    public String saveOrder(OrderDTO orderDTO){


        boolean inStock = orderDTO.getOrderItems()
                .stream()
                .allMatch(orderItem -> stockClient.stockAvailable(orderItem.getCode()));

        if (inStock) {

            Order order = new Order();

            order.setOrderNo(UUID.randomUUID().toString());
            order.setOrderItems(orderDTO.getOrderItems());

            orderRepository.save(order);

            return "Order Saved";
        }

        return "Order can not be saved";
    }

    private String fallbackToStockService() {
        return "Something went wrong, please try later";
    }
}

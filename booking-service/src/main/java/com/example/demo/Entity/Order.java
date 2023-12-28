/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Training Project
 */
package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}

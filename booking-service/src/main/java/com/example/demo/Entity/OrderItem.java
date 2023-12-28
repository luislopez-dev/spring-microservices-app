/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Training Project
 */
package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private BigDecimal price;

    private Integer orderQty;
}

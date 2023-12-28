/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Training Project
 */
package com.example.demo.Repository;

import com.example.demo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

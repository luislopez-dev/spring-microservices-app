/*
 * Author: Luis López
 * Website: https://github.com/luislopez-dev
 * Description: Training Project
 */
package com.example.demo.Controller;

import com.example.demo.Entities.Stock;
import com.example.demo.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping("/{code}")
    public boolean stockAvailable(@PathVariable String code) {
        Optional<Stock> stock = stockRepository.findByCode(code);

        stock.orElseThrow(() -> new RuntimeException("Can not find product" + code));

        return stock.get().getQuantity() > 0;
    }
}

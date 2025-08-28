package com.concesionaria.ms_stocks.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.concesionaria.ms_stocks.model.Stock;
import com.concesionaria.ms_stocks.repository.StockDAO;

import jakarta.annotation.PostConstruct;

@Configuration
public class StockBoostrap {
    @Autowired StockDAO stockDAO;
   

    @PostConstruct
    public void seed() {
        stockDAO.save(new Stock(1L, 1L, 10));
        stockDAO.save(new Stock(2L, 1L, 10));
        stockDAO.save(new Stock(3L, 2L, 5));
        stockDAO.save(new Stock(1L, 2L, 3));
        stockDAO.save(new Stock(2L, 3L, 1));
        stockDAO.save(new Stock(4L, 3L, 4));
    }
}

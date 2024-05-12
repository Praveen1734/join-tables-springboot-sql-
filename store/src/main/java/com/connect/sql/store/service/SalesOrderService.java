package com.connect.sql.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connect.sql.store.repo.t303_salesorder_headerRepository;

@Service
public class SalesOrderService {

    @Autowired
    private t303_salesorder_headerRepository salesOrderRepository;

    public List<Object[]> getSalesOrderDetails() {
        return salesOrderRepository.getSalesOrderDetails();
    }

    // Implement other methods for processing the query results
}
package com.connect.sql.store.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.connect.sql.store.service.SalesOrderService;

@Controller
public class SalesController {

    @Autowired
    private final SalesOrderService salesOrderService;

	/*
	 * @GetMapping("/sales") public List<Object[]> getSalesOrderAndSalesPerson() {
	 * 
	 * return salesOrderHeaderRepository.findSalesOrderDetails();
	 * 
	 * }
	 * 
	 * @GetMapping("/index") public String index() { return "index";
	 */
	//}
    public SalesController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @RequestMapping("/details")
    public String getSalesOrderDetails(Model model) {
        List<Object[]> salesOrderDetails = salesOrderService.getSalesOrderDetails();
        model.addAttribute("salesOrderDetails", salesOrderDetails);
        return "salesOrderDetails"; 
    }
    
    
    
}

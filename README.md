1.repository 

package com.connect.sql.store.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.connect.sql.store.entity.t303_salesorder_header;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;
public interface t303_salesorder_headerRepository extends JpaRepository<t303_salesorder_header, Long> {
	@Query(value = "SELECT  so.s0HeaderId, so.s0Number, sp.salesPersonId, sp.name, so.CustomerId, c.FirstName, p.Name, t.Name, d.Name, inv.Lookup_Value, inv.invoicestatus, packagestatus.packagestatus, Sostatus.sostatus, Shipmentstatus.shipmentstatus, " +
	        "(SELECT COUNT(*) FROM t303_salesorder_header) as totalCount " +
	        "FROM t303_salesorder_header so " +
	        "LEFT JOIN t302_sales_persons sp ON so.s0HeaderId = sp.salesPersonId " + 
	        "LEFT JOIN t100_contact c ON so.CustomerId = c.Contactid " +
	        "LEFT JOIN t201_price_list_header p ON so.PriceListId = p.PriceListHeaderId " + 
	        "LEFT JOIN t008_tax t ON so.TaxId = t.Taxid " +
	        "LEFT JOIN t022_deliverymethod d ON so.DeliveryMethodId = d.DeliverymethodId " + 
	        "LEFT JOIN t004_lookup inv ON so.SOInventoryStatusId = inv.Lookup_Id " + 
	        "LEFT JOIN t004_lookup invStatus ON so.InvoiceStatusId = invStatus.Lookup_Id " +
	        "LEFT JOIN t004_lookup packagestatus ON so.PackageStatusId = packagestatus.Lookup_Id " +
	        "LEFT JOIN t004_lookup Sostatus ON so.SOStatusId = Sostatus.Lookup_Id " + 
	        "LEFT JOIN t004_lookup Shipmentstatus ON so.ShipmentStatusId = Shipmentstatus.Lookup_Id")

	Page<Object[]> getSalesOrderDetails(Long s0HeaderId, String s0Number, Pageable pageable);

	@Query(value = "SELECT Lookup_Value FROM t004_lookup WHERE Lookup_Code = 'SO_INVENTORY STATUS'")
    List<String> getInventoryStatus();

    @Query(value = "SELECT Lookup_Value FROM t004_lookup WHERE Lookup_Code = 'SO_STATUS'")
    List<String> getInvoiceStatus();

    @Query(value = "SELECT Lookup_Value FROM t004_lookup WHERE Lookup_Code = 'package_status'")
    List<String> getPackageStatus();

    @Query(value = "SELECT Lookup_Value FROM t004_lookup WHERE Lookup_Code = 'Shipment status'")
    List<String> getShipmentStatus();
	
}




2.Service
package com.connect.sql.store.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.connect.sql.store.entity.SalesOrderDetails;
import com.connect.sql.store.repo.t303_salesorder_headerRepository;

@Service
public class SalesOrderService {

    @Autowired
    private t303_salesorder_headerRepository salesOrderRepository;


    
    public Page<SalesOrderDetails> getSalesOrderDetails(Long s0HeaderId, String s0Number, int page, int size) 
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<Object[]> salesOrderDetails = salesOrderRepository.getSalesOrderDetails(s0HeaderId, s0Number, pageable);
        List<SalesOrderDetails> mappedDetails = new ArrayList<>();
       
        for (Object[] row : salesOrderDetails.getContent()) 
        {
            SalesOrderDetails details = new SalesOrderDetails();
            details.setS0HeaderId((Long) row[0]);
            details.setS0Number((String) row[1]);
            details.setSalesPersonId((Long) row[2]);
            details.setSalesPersonName((String) row[3]);
            details.setCustomerId((Long) row[4]);
            details.setCustomerFirstName((String) row[5]);
            details.setPriceListName((String) row[6]);
            details.setTaxName((String) row[7]);
            details.setDeliveryMethodName((String) row[8]);
            details.setInventoryStatus((String) row[9]);
            details.setInvoiceStatus((String) row[10]);
            details.setPackageStatus((String) row[11]);
            details.setSoStatus((String) row[12]);
            details.setShipmentStatus((String) row[13]);
            details.settotalCount((long)row[14]);
            mappedDetails.add(details);
            
        }

        return new PageImpl<>(mappedDetails, pageable, salesOrderDetails.getTotalElements());
        
    }
    public List<String> getInventoryStatus() {
        return salesOrderRepository.getInventoryStatus();
    }

    public List<String> getInvoiceStatus() {
        return salesOrderRepository.getInvoiceStatus();
    }

    public List<String> getPackageStatus() {
        return salesOrderRepository.getPackageStatus();
    }

    public List<String> getShipmentStatus() {
        return salesOrderRepository.getShipmentStatus();
    }
    
    
    
}
3.Controller

package com.connect.sql.store.Controller;

import org.springframework.data.domain.Page;

import com.connect.sql.store.entity.SalesOrderDetails;
import com.connect.sql.store.repo.t303_salesorder_headerRepository;
import com.connect.sql.store.service.SalesOrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SalesController {

    @Autowired
    private final SalesOrderService salesOrderService;

	
    public SalesController(SalesOrderService salesOrderService) 
    {
        this.salesOrderService = salesOrderService;
    }


    
    
    @GetMapping("/details")
    public Page<SalesOrderDetails> getSalesOrderDetails(
            @RequestParam(required = false) Long s0HeaderId,
            @RequestParam(required = false) String s0Number,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
    
        return salesOrderService.getSalesOrderDetails(s0HeaderId, s0Number, page, size);
   
}
    

    @GetMapping("/inventoryStatus")
    public List<String> getInventoryStatus() {
        return salesOrderService.getInventoryStatus();
    }

    @GetMapping("/invoiceStatus")
    public List<String> getInvoiceStatus() {
        return salesOrderService.getInvoiceStatus();
    }

    @GetMapping("/packageStatus")
    public List<String> getPackageStatus() {
        return salesOrderService.getPackageStatus();
    }

    @GetMapping("/shipmentStatus")
    public List<String> getShipmentStatus() {
        return salesOrderService.getShipmentStatus();
    }
}
    
    

IN ANGULAR HIT THE VALUE THROUGH HTTP API
1.Service
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesService {

  constructor(private http: HttpClient) { }

  getInventoryStatus(): Observable<string[]> {
    return this.http.get<string[]>('/api/inventoryStatus');
  }

  getInvoiceStatus(): Observable<string[]> {
    return this.http.get<string[]>('/api/invoiceStatus');
  }

  getPackageStatus(): Observable<string[]> {
    return this.http.get<string[]>('/api/packageStatus');
  }

  getShipmentStatus(): Observable<string[]> {
    return this.http.get<string[]>('/api/shipmentStatus');
  }
}
2.Angular Component

import { Component, OnInit } from '@angular/core';
import { SalesService } from './sales.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {

  inventoryStatusOptions: string[] = [];
  invoiceStatusOptions: string[] = [];
  packageStatusOptions: string[] = [];
  shipmentStatusOptions: string[] = [];

  constructor(private salesService: SalesService) { }

  ngOnInit(): void {
    this.getInventoryStatus();
    this.getInvoiceStatus();
    this.getPackageStatus();
    this.getShipmentStatus();
  }

  getInventoryStatus(): void {
    this.salesService.getInventoryStatus().subscribe(options => {
      this.inventoryStatusOptions = options;
    });
  }

  getInvoiceStatus(): void {
    this.salesService.getInvoiceStatus().subscribe(options => {
      this.invoiceStatusOptions = options;
    });
  }

  getPackageStatus(): void {
    this.salesService.getPackageStatus().subscribe(options => {
      this.packageStatusOptions = options;
    });
  }

  getShipmentStatus(): void {
    this.salesService.getShipmentStatus().subscribe(options => {
      this.shipmentStatusOptions = options;
    });
  }
}



3.Html


<div>
  <h2>Inventory Status Options</h2>
  <mat-form-field>
    <mat-label>Inventory Status</mat-label>
    <mat-select>
      <mat-option *ngFor="let option of inventoryStatusOptions" [value]="option">{{ option }}</mat-option>
    </mat-select>
  </mat-form-field>

  <!-- Similar blocks for other status types -->
</div>

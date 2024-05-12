package com.connect.sql.store.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.connect.sql.store.entity.t303_salesorder_header;

import java.util.*;
public interface t303_salesorder_headerRepository extends JpaRepository<t303_salesorder_header, Long> {
    @Query("SELECT so.s0HeaderId, so.s0Number, sp.salesPersonId, sp.name,so.CustomerId,c.FirstName,p.Name,t.Name,"
    		+ "d.Name,inv.Lookup_Value,inv.invoicestatus,packagestatus.packagestatus,Sostatus.sostatus,Shipmentstatus.shipmentstatus " +
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
           "LEFT JOIN t004_lookup Shipmentstatus ON so.ShipmentStatusId = Shipmentstatus.Lookup_Id "


)    

    List<Object[]> getSalesOrderDetails();
 //   List<Object[]> findSalesOrderDetails();
   
}

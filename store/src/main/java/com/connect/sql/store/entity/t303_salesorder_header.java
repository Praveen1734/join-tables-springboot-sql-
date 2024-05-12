package com.connect.sql.store.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="t303_salesorder_header")
@Entity(name = "t303_salesorder_header")
public class t303_salesorder_header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="s0HeaderId")
    
    private Long s0HeaderId;
    @Column(name="s0Number")
    private String s0Number;
	public Long getS0HeaderId() {
		return s0HeaderId;
	}
	@Column(name="CustomerId")
	private long CustomerId;
	@Column(name="PriceListId")
	private long PriceListId;
	@Column(name="TaxId")
	private long TaxId;
	@Column(name="DeliveryMethodId")
	private long DeliveryMethodId;
	@Column(name="SOInventoryStatusId")
	private long SOInventoryStatusId;
	@Column(name="InvoiceStatusId")
	private long InvoiceStatusId;
	public t303_salesorder_header(Long s0HeaderId, String s0Number, long customerId, long priceListId, long taxId,
			long deliveryMethodId, long sOInventoryStatusId, long invoiceStatusId, long packageStatusId,
			long sOStatusId, long shipmentStatusId) {
		super();
		this.s0HeaderId = s0HeaderId;
		this.s0Number = s0Number;
		CustomerId = customerId;
		PriceListId = priceListId;
		TaxId = taxId;
		DeliveryMethodId = deliveryMethodId;
		SOInventoryStatusId = sOInventoryStatusId;
		InvoiceStatusId = invoiceStatusId;
		PackageStatusId = packageStatusId;
		SOStatusId = sOStatusId;
		ShipmentStatusId = shipmentStatusId;
	}
	@Column (name="PackageStatusId")
	private long PackageStatusId;
	@Column(name="SOStatusId")
	private long SOStatusId;
	@Column(name="ShipmentStatusId")
	private long ShipmentStatusId;
	
	public long getPriceListId() {
		return PriceListId;
	}
	public void setPriceListId(long priceListId) {
		PriceListId = priceListId;
	}
	public long getTaxId() {
		return TaxId;
	}
	public void setTaxId(long taxId) {
		TaxId = taxId;
	}
	public long getDeliveryMethodId() {
		return DeliveryMethodId;
	}
	public void setDeliveryMethodId(long deliveryMethodId) {
		DeliveryMethodId = deliveryMethodId;
	}
	public long getSOInventoryStatusId() {
		return SOInventoryStatusId;
	}
	public void setSOInventoryStatusId(long sOInventoryStatusId) {
		SOInventoryStatusId = sOInventoryStatusId;
	}
	public long getInvoiceStatusId() {
		return InvoiceStatusId;
	}
	public void setInvoiceStatusId(long invoiceStatusId) {
		InvoiceStatusId = invoiceStatusId;
	}
	public long getPackageStatusId() {
		return PackageStatusId;
	}
	public void setPackageStatusId(long packageStatusId) {
		PackageStatusId = packageStatusId;
	}
	public long getSOStatusId() {
		return SOStatusId;
	}
	public void setSOStatusId(long sOStatusId) {
		SOStatusId = sOStatusId;
	}
	public long getShipmentStatusId() {
		return ShipmentStatusId;
	}
	public void setShipmentStatusId(long shipmentStatusId) {
		ShipmentStatusId = shipmentStatusId;
	}
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	
	public void setS0HeaderId(Long s0HeaderId) {
		this.s0HeaderId = s0HeaderId;
	}
	public String getS0Number() {
		return s0Number;
	}
	public void setS0Number(String s0Number) {
		this.s0Number = s0Number;
	}

    // Getters and setters
}

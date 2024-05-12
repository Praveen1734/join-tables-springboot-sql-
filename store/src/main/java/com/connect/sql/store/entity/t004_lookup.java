package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "t004_lookup")
@Table(name = "t004_lookup")
public class t004_lookup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Lookup_Id")
    private long Lookup_Id;
    
    @Column(name="Lookup_Value")
    private String Lookup_Value;

    @Column(name="packagestatus")
    private String packagestatus;
    
    @Column(name="sostatus")
    private String sostatus;
    
    @Column(name="shipmentstatus")
    private String shipmentstatus;
    
    @Column(name="invoicestatus")
    private String invoicestatus;
	

	

	public t004_lookup(long lookup_Id, String lookup_Value, String packagestatus, String sostatus,
			String shipmentstatus, String invoicestatus) {
		super();
		Lookup_Id = lookup_Id;
		Lookup_Value = lookup_Value;
		this.packagestatus = packagestatus;
		this.sostatus = sostatus;
		this.shipmentstatus = shipmentstatus;
		this.invoicestatus = invoicestatus;
	}

	public String getSostatus() {
		return sostatus;
	}

	public void setSostatus(String sostatus) {
		this.sostatus = sostatus;
	}

	public String getShipmentstatus() {
		return shipmentstatus;
	}

	public void setShipmentstatus(String shipmentstatus) {
		this.shipmentstatus = shipmentstatus;
	}

	public String getPackagestatus() {
		return packagestatus;
	}

	public void setPackagestatus(String packagestatus) {
		this.packagestatus = packagestatus;
	}

	public long getLookup_Id() {
		return Lookup_Id;
	}

	

	public void setLookup_Id(long lookup_Id) {
		Lookup_Id = lookup_Id;
	}

	public String getLookup_Value() {
		return Lookup_Value;
	}

	public void setLookup_Value(String lookup_Value) {
		Lookup_Value = lookup_Value;
	}
    
}

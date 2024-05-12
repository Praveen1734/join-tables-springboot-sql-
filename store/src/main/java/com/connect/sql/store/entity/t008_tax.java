package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "t008_tax")
@Table(name = "t008_tax")
public class t008_tax {
   

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Taxid")
	private long Taxid;
	
	public t008_tax(int taxid, String name) {
		super();
		Taxid = taxid;
		Name = name;
	}

	public long getTaxid() {
		return Taxid;
	}

	public void setTaxid(int taxid) {
		Taxid = taxid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Column(name="Name")
	private String Name;
}


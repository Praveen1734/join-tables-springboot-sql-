package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "t201_price_list_header")
@Table(name = "t201_price_list_header")
public class t201_price_list_header {
    public t201_price_list_header(int priceListHeaderId, String name) {
		super();
		PriceListHeaderId = priceListHeaderId;
		Name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PriceListHeaderId")
    private int PriceListHeaderId;
    
    public int getPriceListHeaderId() {
		return PriceListHeaderId;
	}

	public void setPriceListHeaderId(int priceListHeaderId) {
		PriceListHeaderId = priceListHeaderId;
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
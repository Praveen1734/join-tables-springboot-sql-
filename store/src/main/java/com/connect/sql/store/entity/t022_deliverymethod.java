package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "t022_deliverymethod")
@Table(name = "t022_deliverymethod")
public class t022_deliverymethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DeliverymethodId")
    private long DeliverymethodId;
    
    public t022_deliverymethod(long deliverymethodId, String name) {
		super();
		DeliverymethodId = deliverymethodId;
		Name = name;
	}

	public long getDeliverymethodId() {
		return DeliverymethodId;
	}

	public void setDeliverymethodId(long deliverymethodId) {
		DeliverymethodId = deliverymethodId;
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
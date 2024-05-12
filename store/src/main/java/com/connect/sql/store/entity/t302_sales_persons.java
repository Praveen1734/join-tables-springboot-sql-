package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name = "t302_sales_persons")
@Table(name = "t302_sales_persons")
public class t302_sales_persons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="salesPersonId")
    private Long salesPersonId;
    public t302_sales_persons(Long salesPersonId, String name) {
		super();
		this.salesPersonId = salesPersonId;
		this.name = name;
	}
	public Long getSalesPersonId() {
		return salesPersonId;
	}
	public void setSalesPersonId(Long salesPersonId) {
		this.salesPersonId = salesPersonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="name")
    private String name;

    // Getters and setters
}

package com.connect.sql.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "t100_contact")
@Table(name = "t100_contact")
public class t100_contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Contactid ")
    private long Contactid;
    
    @Column(name="FirstName")
    private String FirstName;

	public long getContactid() {
		return Contactid;
	}

	public t100_contact(long contactid, String firstName) {
		super();
		Contactid = contactid;
		FirstName = firstName;
	}

	public void setContactid(long contactid) {
		Contactid = contactid;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
    
    
    
    

}
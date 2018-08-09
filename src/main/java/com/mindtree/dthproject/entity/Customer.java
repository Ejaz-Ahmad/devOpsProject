package com.mindtree.dthproject.entity;
import javax.persistence.*;
@Entity
@Table(name = "customers")
public class Customer {
	 @Id @GeneratedValue
	   @Column(name = "subscriber_id")
	   private int subscriberId;
	 
	   @Column(name = "registered_mobile")
	   private int registeredMobile;

	   @Column(name = "first_name")
	   private String firstName;

	   @Column(name = "last_name")
	   private String lastName;

	   

	public int getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}

	public int getRegisteredMobile() {
		return registeredMobile;
	}

	public void setRegisteredMobile(int registeredMobile) {
		this.registeredMobile = registeredMobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}  
	   
	   
    
	   
}

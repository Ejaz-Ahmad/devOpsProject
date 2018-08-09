package com.mindtree.dthproject.entity;

import javax.persistence.*;
@Entity
@Table(name = "subscriptiondetails")
public class SubscriptionDetails {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	 
	   @Column(name = "id")
	   private int Id;
	 
	   @Column(name = "subscription_date")
	   private String subscriptionDate;

	   @Column(name = "channel_id")
	   private int channelId;
	   
	   @Column(name = "subscriber_id")
	   private int subscriberId;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = (String)subscriptionDate;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	   
	   

}

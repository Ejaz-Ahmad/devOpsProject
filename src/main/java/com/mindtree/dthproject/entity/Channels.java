package com.mindtree.dthproject.entity;
import javax.persistence.*;
@Entity
@Table(name = "channels")
public class Channels {
	 @Id @GeneratedValue
	   @Column(name = "channel_id")
	   private int channelId;
	 
	   @Column(name = "channel_name")
	   private String channelName;

	   @Column(name = "cost_per_month")
	   private String costPerMonth;

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCostPerMonth() {
		return costPerMonth;
	}

	public void setCostPerMonth(String costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	   
	   
	   

}
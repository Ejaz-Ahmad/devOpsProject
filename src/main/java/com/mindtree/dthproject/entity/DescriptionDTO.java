package com.mindtree.dthproject.entity;

import java.util.List;

public class DescriptionDTO {
	private int customerId;
	private String name;
	private double totalSubscriptionCost;
	List<Channels> subscribedChannels;
	
	public DescriptionDTO(int customerId, String name, double totalSubscriptionCost,
			List<Channels> subscribedChannels) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.totalSubscriptionCost = totalSubscriptionCost;
		this.subscribedChannels = subscribedChannels;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalSubscriptionCost() {
		return totalSubscriptionCost;
	}

	public void setTotalSubscriptionCost(double totalSubscriptionCost) {
		this.totalSubscriptionCost = totalSubscriptionCost;
	}

	public List<Channels> getSubscribedChannels() {
		return subscribedChannels;
	}

	public void setSubscribedChannels(List<Channels> subscribedChannels) {
		this.subscribedChannels = subscribedChannels;
	}
	
	
	
	
}	
package com.mindtree.dthproject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.dthproject.entity.Channels;
import com.mindtree.dthproject.entity.Customer;
import com.mindtree.dthproject.entity.DescriptionDTO;
import com.mindtree.dthproject.entity.SubscriptionDetails;

public class DaoImplementation {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Channels> getAllChannels() {
		List<Channels> channels = null;
		Transaction transaction = null;
		/*
		 * SessionFactory sessionFactory =
		 * HibernateUtil.getSessionFactoryObject();
		 */
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String fromChan = "from Channels";
		Query query = session.createQuery(fromChan);
		channels = query.list();
		session.flush();
		transaction.commit();
		return channels;
	}

	public void insertingData(String date, int channelId, int subscriberId) {
		System.out.println(date + " " + channelId + " " + subscriberId);
		Transaction transaction = null;
		/*
		 * SessionFactory sessionFactory =
		 * HibernateUtil.getSessionFactoryObject();
		 */
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Add new Employee object
		SubscriptionDetails obj = new SubscriptionDetails();
		obj.setSubscriptionDate(date);
		obj.setSubscriberId(subscriberId);
		obj.setChannelId(channelId);

		// Save the employee in database
		session.save(obj);

		// Commit the transaction
		session.getTransaction().commit();
		System.out.println("Details are Inserted in Database");
		// HibernateUtil.shutdown();
	}

	public List<Customer> customerDetails(int subscriptionId) {
		System.out.println("CustomerDetails Function Check");
		List<Customer> customer = new ArrayList<Customer>();
		Transaction transaction = null;
		/*
		 * SessionFactory sessionFactory =
		 * HibernateUtil.getSessionFactoryObject();
		 */
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println("God is Great" + subscriptionId);
		String query = "from Customer where subscriberId='" + subscriptionId + "'";
		Query queryResult = session.createQuery(query);
		System.out.println("hello world" + queryResult.list().size());
		customer = queryResult.list();
		return customer;

	}

	public List<Channels> subscription(int subscriptionId) {
		List<Channels> detail = new ArrayList<Channels>();
		Transaction transaction = null;
		/*
		 * SessionFactory sessionFactory =
		 * HibernateUtil.getSessionFactoryObject();
		 */
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String query = "from Channels where channelId in (select channelId from SubscriptionDetails where subscriberId='"
				+ subscriptionId + "')";
		Query queryResult = session.createQuery(query);
		detail = queryResult.list();
		return detail;

	}

	public DescriptionDTO gettingDisplayDescription(int subscriptionId) {

		System.out.println(subscriptionId);
		List<Channels> detail1 = new ArrayList<Channels>();
		detail1 = subscription(subscriptionId);
		List<Customer> customer1 = customerDetails(subscriptionId);

		System.out.println(detail1.get(0).getChannelName() + " " + detail1.get(0).getCostPerMonth());
		System.out.println(subscriptionId);
		System.out.println("This is coming till here");
		int customerId = 0;
		customerId = customer1.get(0).getSubscriberId();
		String customerName = customer1.get(0).getFirstName() + " " + customer1.get(0).getLastName();
		System.out.println(customerName);
		double cost = 0.0;
		for (int i = 0; i < detail1.size(); i++) {
			cost = cost + Double.parseDouble(detail1.get(i).getCostPerMonth());
		}
		System.out.println(cost);

		DescriptionDTO dtoObject = new DescriptionDTO(customerId, customerName, cost, detail1);

		return dtoObject;

	}

	public int returnChannelId(String channelName) {
		System.out.println("scope check");
		Transaction transaction = null;
		/*
		 * SessionFactory sessionFactory =
		 * HibernateUtil.getSessionFactoryObject();
		 */
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String fromChan = "from Channels where channelName='" + channelName + "'";
		Query query = session.createQuery(fromChan);
		List<Channels> channel = query.list();

		System.out.println(channel.get(0).getChannelId());

		session.flush();
		transaction.commit();
		return channel.get(0).getChannelId();
	}
}


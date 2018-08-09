package com.mindtree.dthproject.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.mindtree.dthproject.dao.DaoImplementation;
import com.mindtree.dthproject.entity.Channels;
import com.mindtree.dthproject.entity.DescriptionDTO;
import com.mindtree.dthproject.entity.SubscriptionDetails;


@Controller
public class MyController {
	
	
	@Autowired 
	private DaoImplementation daoObject;
	@RequestMapping(value = "/MainController", method = RequestMethod.GET)
	public ModelAndView returningSubscriptionForm(HttpServletRequest request)
	{
		List<Channels> channelList=daoObject.getAllChannels();
		ModelAndView mav=new ModelAndView("dthSubscription","subscriptionDetails",new SubscriptionDetails());
		request.setAttribute("channels", channelList);
		return mav;
		
		
	}

	@RequestMapping(value = "/insertingDetails", method = RequestMethod.POST)
	   public ModelAndView addingSubscriptionDetails(@ModelAttribute SubscriptionDetails subscriptionObject)
	    {
		System.out.println("Hi Bro"+subscriptionObject.getSubscriberId());
		daoObject.insertingData(subscriptionObject.getSubscriptionDate(), subscriptionObject.getChannelId(), subscriptionObject.getSubscriberId());
		ModelAndView mav=new ModelAndView("Home");
		return mav;
	}
	
			
 
	 
	
	@RequestMapping(value = "/displayingdetails", method = RequestMethod.POST)
	public ModelAndView displayingDetails(@RequestParam("subscriptionId") int Id ,HttpServletRequest request)
	{
		ModelAndView mav =new ModelAndView("display");
		
		DescriptionDTO obj=null;
		obj=daoObject.gettingDisplayDescription(Id);
		System.out.println(obj.getName());
		request.setAttribute("object", obj);
		
		StringBuffer sb = new StringBuffer(obj.getName());
		sb.append("_");
		sb.append(obj.getCustomerId());
				
					try {
						File file = new File(sb.toString());
						FileWriter fileWriter = new FileWriter(file, true);
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.flush();
						bw.newLine();
						// for (Orders orders : orderList) {
						bw.append("Customer Name");
						bw.append(obj.getName());
						bw.newLine();
						bw.append(String.valueOf(obj.getCustomerId()));
						bw.newLine();
						bw.append("Total Cost");
						bw.append(String.valueOf(obj.getTotalSubscriptionCost()));
						bw.newLine();
						bw.flush();
						bw.close();

						System.out.println("Data written in file");
					} catch (Exception exception) {
						exception.printStackTrace();
					}

		
			return mav;
	}
		
		
}
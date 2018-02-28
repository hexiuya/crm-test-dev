package com.crm.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.test.model.Customer;
import com.crm.test.service.CustomerService;
import com.crm.test.util.EmailUtil;

@Controller
@RequestMapping(value = "/onlineManage")
public class OnlineController {

	@Autowired
    private EmailUtil emailUtil;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/register" ,method = RequestMethod.POST)
	@ResponseBody
	public String register(Customer customer){
		
		System.out.println(customer.getUsername());
		
		int rowns = customerService.insertCustomer(customer);
		
		if(1 != rowns){
			return "register failed";
		}
		
		return "register";
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	@ResponseBody
	public String login(Customer customer,HttpServletRequest request){
		String username = customer.getUsername();
		String password = customer.getPassword();
		System.out.print(username);
		customer = customerService.selectCustomerByUserName(username,password);
		if(null == customer){
			return "login failed";
		}
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("username"));
		
		session.setAttribute("username", username);
		
		return "login success";
	}
	
	@RequestMapping(value = "/logout" ,method = RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("username"));
		
		session.removeAttribute("username");
		return "loginout success";
	}
	
	@RequestMapping(value = "/sendEmail" ,method = RequestMethod.POST)
	@ResponseBody
	public String sendEmail(HttpServletRequest request){
		String acceptorAccount = request.getParameter("acceptorAccount");
		try {
			emailUtil.sendTemplateMail(acceptorAccount, "test email");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "send email fail !";
		}
		return "send email success !";
	}
}

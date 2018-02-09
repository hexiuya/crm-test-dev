package com.crm.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.test.task.ScheduledTask;
import com.crm.test.util.EmailUtil;

@Controller
@RequestMapping(value = "/onlineManage")
public class OnlineController {

	@Autowired
    private EmailUtil emailUtil;
	
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	@ResponseBody
	public String login(HttpServletRequest request){
		
		return "login success";
	}
	
	@RequestMapping(value = "/logout" ,method = RequestMethod.GET)
	@ResponseBody
	public String logout(HttpServletRequest request){
		
		return "loginout success";
	}
	
	@RequestMapping(value = "/sendEmail" ,method = RequestMethod.GET)
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

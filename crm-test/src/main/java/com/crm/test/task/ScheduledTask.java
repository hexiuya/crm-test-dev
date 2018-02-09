package com.crm.test.task;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;


@Component
public class ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Value("${spring.mail.username}")
	private String sendMailAccount;
	
    public String[] getMailBuyBackAcceptArray(String mailBuyBackAcceptGroup){
    	String[] acceptors = mailBuyBackAcceptGroup.split(",");
    	return acceptors;
    }
    
    public String[] getMailExceptionInformArray(String mailExceptionInformGroup){
    	String[] acceptors = mailExceptionInformGroup.split(",");
    	return acceptors;
    }
    
    public void sendTemplateMail(String acceptorAccount,String emailContent) throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(sendMailAccount);
		helper.setTo(acceptorAccount);
		helper.setSubject("提醒邮件");

		Map<String, Object> model = new HashedMap();
		model.put("emailContent", emailContent);
		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "template.vm", "UTF-8", model);
		helper.setText(text, true);

		mailSender.send(mimeMessage);
	}
}

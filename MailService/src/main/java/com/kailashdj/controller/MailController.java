package com.kailashdj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kailashdj.model.Mail;
import com.kailashdj.service.impl.MailServiceImpl;

@RestController
public class MailController {

	@Autowired
	private MailServiceImpl mailService;
	
	@RequestMapping(value = "/sendemail")
	public String sendMail() {
		Mail mail = new Mail();
		mail.setMailFrom("kailashdjniraula9@gmail.com");
		mail.setMailTo("badri@ncit.edu.np");
		mail.setMailSubject("Spring Boot - Email Service");
		mail.setMailContent("Learn how to send email using Spring Boot!");
		mailService.sendMail(mail);
		return "Mail Sent!";
	}
}

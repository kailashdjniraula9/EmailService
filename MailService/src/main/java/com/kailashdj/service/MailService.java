package com.kailashdj.service;

import javax.mail.MessagingException;

import com.kailashdj.model.Mail;

public interface MailService {
	
	public void sendMail(Mail mail) throws MessagingException;
	public void sendMailWithAttachment(Mail mail) throws MessagingException;
}

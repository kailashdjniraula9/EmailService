package com.kailashdj.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kailashdj.model.Mail;
import com.kailashdj.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(Mail mail) {
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		try {
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setText(mail.getMailContent());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

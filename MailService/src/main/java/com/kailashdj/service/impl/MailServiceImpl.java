package com.kailashdj.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.kailashdj.model.Mail;
import com.kailashdj.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendMail(Mail mail) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		try {
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setText(mail.getMailContent());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			
			String name = mail.getMailTo().split("@")[0];
			
			mimeMessage.setContent(
					"<html>"
					+"<head>"
					+ "<h1>Hello&nbsp;"+ name +"</h1>"
					+"</head>"
					+ "<body>"
					+ "<p>"
					+ "Please click the button below"
					+ "or use the following url to reset your password."
					+ "<button>"
					+ "Reset Password"
					+ "</button>"
					+ "</p>"
					+ "<p>"
					+ "With Regards"
					+ "<br>"
					+ "Kailashdj Niraula"
					+ "</p>"
					+ "</body>"
					+ "</html>"
					+mail.getMailTo(),
					"text/html");

			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void sendMailWithAttachment(Mail mail) throws MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		try {
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setText(mail.getMailContent());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());

			FileSystemResource file = new FileSystemResource("D:\\Wallpapers\\383271.jpg");
			mimeMessageHelper.addAttachment(file.getFilename(), file);

			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

}

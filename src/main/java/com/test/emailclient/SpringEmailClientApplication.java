package com.test.emailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		service.sendSimpleEmail(
//				"prabhathudayanga1998@gmail.com",
//				"This is email body",
//				"This is email subject"
//		);

		service.sendEmailWithAttachment("prabhathudayanga1998@gmail.com","body with attachment","this is subject","/home/prabath/Pictures/param.png");
	}

}

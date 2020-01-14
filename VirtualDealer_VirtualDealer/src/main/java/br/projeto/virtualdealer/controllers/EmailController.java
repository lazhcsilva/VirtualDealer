package br.projeto.virtualdealer.controllers;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.projeto.virtualdealer.model.Cliente;

@Controller
public class EmailController {
 
	@Autowired 
	private JavaMailSender mailSender;
	
	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
	public String sendMail(Cliente cliente) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo(cliente.getEmailCliente());
			helper.setSubject("Confirmação de abertura de conta");
			helper.setText("<h1>Para que sua conta seja aberta clique no link: </h1>");
			mailSender.send(mail);
			return "ok";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "erro ao enviar";
		
		}
	}
 
}
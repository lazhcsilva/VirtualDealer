package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@RequestMapping("/salvarFormularioCliente")
	public String cade( String email) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(email);
	        msg.setSubject("Testando envio");
	        msg.setText("http://localhost:8080/cadastro");

	        javaMailSender.send(msg);
			return "/index2";

	    }
	
	@RequestMapping("/cade")
	public String cad(@RequestParam String hash) {
		 SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(hash);
	        msg.setSubject("Testando envio");
	        msg.setText("http://localhost:9090/cad	");

	        javaMailSender.send(msg);
			return "/index2";

	    }
	
	
}

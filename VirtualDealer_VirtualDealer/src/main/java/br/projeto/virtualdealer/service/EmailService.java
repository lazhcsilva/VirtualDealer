package br.projeto.virtualdealer.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.virtualdealer.dao.EmailDAO;
import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.model.Email;
import br.projeto.virtualdealer.model.EmailMensagem;

@Service
public class EmailService {

	@Autowired
	private EmailDAO emailDAO;
	
	private final String username = "cupuladoti@gmail.com";
	private final String password = "projeto2019";
	
	public void enviarConfirmacaoDeConta(Cliente cliente) throws MessagingException {
		
		LocalDate agora = LocalDate.now();
		LocalDate validade = agora.plusDays(2);

		EmailMensagem mensagem = new EmailMensagem();
		mensagem.setTitulo("Olá, " + cliente.getNome() + ". Ative sua conta!");
		mensagem.setMensagem("Para ter acesso total ao nosso site, ative sua conta, copiando esse endereço abaixo e colando na url. (este email vence em: "
				+ validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")");
		;
		mensagem.setController("/ativarConta");

		Email emailConfirmacao = new Email();
		emailConfirmacao.setAssunto("VirtualDealer - Confirme sua conta!");
		emailConfirmacao.setMensagem(mensagem);
		emailConfirmacao.setNomeRemetente("VirtualDealer");
		emailConfirmacao.setEmailRemetente("cupuladoti@gmail.com");
		emailConfirmacao.setNomeDestiantario(cliente.getNome());
		emailConfirmacao.setEmailDestinatario(cliente.getEmailCliente());
		emailConfirmacao.setValidade(validade);
		
		boolean comTolken = true;

		this.sendEmailTSL(emailConfirmacao, comTolken);
	}
	
	public void sendEmailTSL(Email email, boolean comTolken) throws MessagingException {
		
		email.setToken(UUID.randomUUID().toString());

		email.getMensagem().setTokenEmail(email.getToken());

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		session.setDebug(true);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email.getEmailRemetente()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmailDestinatario()));
		message.setSubject(email.getAssunto());
		message.setContent(email.getMensagem().gerarMensagemComTolken(comTolken), "text/html");

		Transport.send(message);
		this.emailDAO.save(email);
	
	}
	
}

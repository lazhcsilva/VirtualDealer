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

	private final String username = "cupuladoti@gmail.com";
	
	private final String password = "projeto2019";

	@Autowired
	private EmailDAO emailRep;

	public Email findByToken(String token) {
	
		return this.emailRep.findByToken(token);
	
	}

	public void salvarRegistro(Email email) {
	
		this.emailRep.save(email);
	
	}

	public boolean validarVencimento(Email email) {
		
		LocalDate agora = LocalDate.now();

		if (email.getValidade().isAfter(agora)) {
		
			return true;
		
		}

		return false;
	
	}
	
	public void enviarConfirmacaoDeConta(Cliente cliente) throws MessagingException {
		
		LocalDate agora = LocalDate.now();
		LocalDate validade = agora.plusDays(5);


		EmailMensagem mensagem = new EmailMensagem();
		mensagem.setTitulo("Olá, " + cliente.getNome() + ". Ative sua conta!");
		mensagem.setMensagem("Para ter acesso total ao nosso site ative sua conta, copiando esse endereço abaixo e colando na url. (este email vence em: "
				+ validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")");
		;
		mensagem.setController("/ativarConta");

		Email emailConfirmacao = new Email();
		emailConfirmacao.setAssunto("VirtualDealer - confirmar conta!");
		emailConfirmacao.setMensagem(mensagem);
		emailConfirmacao.setNomeRemetente("Virtual Dealer");
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
		this.emailRep.save(email);
	}
	
		public void enviarRecuperacaoDeSenha(String emailCliente, String nome, String novasenha) throws MessagingException{
		
		EmailMensagem mensagem = new EmailMensagem();
		mensagem.setTitulo("Olá, " +  nome + "  recupere sua senha!");
		mensagem.setMensagem("Sua nova senha é:  " + novasenha + "  (Não se preocupe,você pode muda-la em nossa página')");
				

		Email recuperacaoDeSenha =  new Email();
		recuperacaoDeSenha.setAssunto("VirtualDealer - Recuperacao de senha!!");
		recuperacaoDeSenha.setMensagem(mensagem);
		recuperacaoDeSenha.setNomeRemetente("Virtual Dealer");
		recuperacaoDeSenha.setEmailRemetente("cupuladoti@gmail.com");
		recuperacaoDeSenha.setNomeDestiantario(nome);
		recuperacaoDeSenha.setEmailDestinatario(emailCliente);

		boolean semTolken = false;
		
		this.sendEmailTSL(recuperacaoDeSenha, semTolken);
		
		
	}
	
}

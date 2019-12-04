package br.projeto.virtualdealer.controllers;



import org.springframework.stereotype.Controller;

@Controller
public class EmailController {
	
	
	
	
	
	
	
	/*
	
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	
	private static final String SMTP_PORT = "465";

	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

	public void sendSSLMessage(String recipients[], String subject,
		String message) throws MessagingException {
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Session session = Session.getDefaultInstance(props,  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lazhcsilva@gmail.com", "lazhc193244");
			}
		});
		
		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		
		InternetAddress addressFrom = new InternetAddress();
		msg.setFrom(addressFrom);
		
		msg.setHeader("Reply-To", "<lazhcsilva@gmail.com>");

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}

		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject(subject);
		msg.setContent(message, "text/html; charset=\"iso-8859-1\"");
		Transport.send(msg);
	}
	
	public static void main(String args[]) throws Exception {
		
		EmailController javaMail = new EmailController();
		String[] recipients = {"lazhcsilva@gmail.com"};
		String subject = "Assunto";
		String message = "Corpo do E-mail";
			
		try {
			javaMail.sendSSLMessage(recipients, subject, message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		System.out.println("Email enviado com sucesso para os destinatarios!");
	
	}
	*/
}

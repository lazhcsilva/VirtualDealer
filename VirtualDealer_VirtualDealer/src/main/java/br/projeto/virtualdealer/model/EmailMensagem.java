package br.projeto.virtualdealer.model;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class EmailMensagem {

	private String titulo;

	@Transient
	private String tokenEmail;
	
	private String mensagem;
	
	private String controller;

	public EmailMensagem() {

	}

	public EmailMensagem(String titulo, String tokenEmail, String mensagem) {
		
		super();
		
		this.titulo = titulo;
	
		this.tokenEmail = tokenEmail;
		
		this.mensagem = mensagem;
	
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTokenEmail() {
		return tokenEmail;
	}

	public void setTokenEmail(String tokenEmail) {
		this.tokenEmail = tokenEmail;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String gerarMensagemComTolken(boolean comTolken) {
		StringBuilder mensagem = new StringBuilder();

		mensagem.append("<h1>" + this.getTitulo() + "</h1><br><br>");

		mensagem.append("<p>" + this.getMensagem() + "</p><br>");

		if ((comTolken == true)) {
		mensagem.append("<p>" + "<a href=\"localhost:8080" + this.getController() + "?token=" + this.getTokenEmail()
				+ "\">" + "localhost:8080" + this.getController() + "?token=" + this.getTokenEmail() + "</a>");
		}

		return mensagem.toString();
	}
	
}

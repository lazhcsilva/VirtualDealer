package br.projeto.virtualdealer.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.virtualdealer.dao.ClienteDAO;
import br.projeto.virtualdealer.model.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO clienteDAO;
	
	public Cliente findClienteByEmail(String emailCliente) {
		return clienteDAO.findByEmailIgnoreCase(emailCliente);
	}
	
	public Cliente findClienteByCpf(String cpf) {
		return clienteDAO.findByCpfIgnoreCase(cpf);
	}
	
	public boolean salvarCliente(Cliente cliente)throws ServiceException, MessagingException {
		
		if (this.findClienteByEmail(cliente.getEmailCliente()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		} 
		else if (this.findClienteByCpf(cliente.getCpf()) != null) {
			throw new ServiceException("Já existe um usuário com este cpf");
		}  else {
				String senhaCriptografada;
				try {
					senhaCriptografada = criptografarSenha(cliente.getPassword());
					cliente.setPassword(senhaCriptografada);
					this.clienteDAO.save(cliente);	
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.save(cliente);
				return true;
	       
		}	
		 
	}
	
	public void save(Cliente cliente) {
	
		this.clienteDAO.save(cliente);
	
	}
	
	public String criptografarSenha(String password)  throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
	 String senhaCriptografada = null;
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		senhaCriptografada = hexString.toString();	
		algorithm.reset();
		
		return senhaCriptografada;
		
	}
	
	public Cliente clienteLogin(String emailCliente, String password) throws ServiceException, NoSuchAlgorithmException, UnsupportedEncodingException {	
		
		String senhaCriptografada = criptografarSenha(password);
		Cliente cliente = this.clienteDAO.clienteLogin(emailCliente, senhaCriptografada);

		if (cliente == null) {
			throw new ServiceException("Login/senha não encontrados");
		}

		return cliente;
	}
	
}

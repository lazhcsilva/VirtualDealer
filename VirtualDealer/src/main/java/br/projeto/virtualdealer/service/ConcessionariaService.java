package br.projeto.virtualdealer.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.virtualdealer.dao.ConcessionariaDAO;
import br.projeto.virtualdealer.model.Concessionaria;

@Service
public class ConcessionariaService {

	@Autowired
	private ConcessionariaDAO concessionariaDAO; 
	
	public boolean salvarConcessionaria(Concessionaria concessionaria)throws ServiceException, MessagingException {
		
		if (this.findConcessionariaByEmail(concessionaria.getEmailConcessionaria()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		} 
		else if (this.findConcessionariaByCnpj(concessionaria.getCnpj()) != null) {
			throw new ServiceException("Já existe um usuário com este cpf");
		}
		else if (this.findConcessionariaByInscricaoEstadual(concessionaria.getInscricaoEstadual()) != null) {
			throw new ServiceException("Já existe uma concessionaria com esta Inscricao Estadual");
		}
		else if (this.findConcessionariaByRazaoSocial(concessionaria.getRazaoSocial()) != null) {
			throw new ServiceException("Já existe uma concessionaria com esta Razão Social");
		}  else {
				String senhaCriptografada;
				try {
					senhaCriptografada = criptografarSenha(concessionaria.getPassword());
					concessionaria.setPassword(senhaCriptografada);
					this.concessionariaDAO.save(concessionaria);	
				} catch (Exception e) {
					
				}
				this.save(concessionaria);
				return true;
	       
		}	
		 
	}
	
	public void save(Concessionaria concessionaria) {
		
		this.concessionariaDAO.save(concessionaria);
	
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
	
	public Concessionaria findConcessionariaByEmail(String emailConcessionaria) {
		return concessionariaDAO.findByEmailIgnoreCase(emailConcessionaria);
	}
	
	public Concessionaria findConcessionariaByCnpj(String cnpj) {
		return concessionariaDAO.findByCnpjIgnoreCase(cnpj);
	}

	public Concessionaria findConcessionariaByInscricaoEstadual(String inscricaoEstadual) {
		return concessionariaDAO.findByInscricaoEstadualIgnoreCase(inscricaoEstadual);
	}
	
	public Concessionaria findConcessionariaByRazaoSocial(String razaoSocial) {
		return concessionariaDAO.findByRazaoSocialIgnoreCase(razaoSocial);
	}
	
}

package br.projeto.virtualdealer.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.virtualdealer.dao.ClienteDAO;
import br.projeto.virtualdealer.dao.ConcessionariaDAO;
import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.model.Concessionaria;

@Controller
public class LoginController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ConcessionariaDAO concessionariaDAO;
	
	@PostMapping("/clienteLogin")
	public String efetuarLogin(@ModelAttribute("cliente") Cliente cliente, BindingResult br, Model model, HttpSession session) throws NoSuchAlgorithmException {
		
		if(br.hasErrors()) {
			
			System.out.println("Resultado: " + br);
		
		}
		
		cliente = clienteDAO.clienteLogin(cliente.getEmailCliente(), cliente.getPassword());
		
		if(cliente == null) {
			
			model.addAttribute("mensagem", "Usuario e senha invalido");
		
		} else {
			
			session.setAttribute("clienteLogado", cliente);
			
			return "/perfil";
			
		}
		
		return "index";
	}
	
	@PostMapping("/concessionariaLogin")
	public String efetuarLoginConcessionaria(@ModelAttribute("concessionaira") Concessionaria concessionaria, BindingResult tr, Model model, HttpSession session) throws NoSuchAlgorithmException {
		
		if(tr.hasErrors()) {
			System.out.println("Resultado: " + tr);
		}
		
		Concessionaria concessionariaConsultada = concessionariaDAO.buscaLoginConcessionaria(concessionaria.getEmailConcessionaria(), concessionaria.getPassword());
		
		if(concessionariaConsultada == null) {
			
			model.addAttribute("mensagem", "Email e senha invalido");
			
		} else {
			
			session.setAttribute("ConcessionariaLogada", concessionariaConsultada);
			return "perfilConcessionaria";
		
		}
		
		return null;
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}
}
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
import br.projeto.virtualdealer.model.Cliente;

@Controller
public class LoginController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@PostMapping("/clienteLogin")
	public String efetuarLogin(@ModelAttribute("cliente") Cliente cliente, BindingResult br, Model model, HttpSession session) throws NoSuchAlgorithmException {
		
		if(br.hasErrors()) {
			System.out.println("Resultado: " + br);
		}
		
		Cliente clienteConsultado = clienteDAO.buscaLogin(cliente.getEmailCliente(), (cliente.getPassword()));
		
		if(clienteConsultado == null) {
			model.addAttribute("mensagem", "Usuario e senha invalido");
		} else {
			session.setAttribute("clienteLOgado", clienteConsultado);
			return "perfil";
		}
		
		return null;
	}
}
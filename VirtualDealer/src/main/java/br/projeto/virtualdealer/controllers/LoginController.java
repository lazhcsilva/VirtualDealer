package br.projeto.virtualdealer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.projeto.virtualdealer.model.Cliente;

@Controller
public class LoginController {
	
	@PostMapping("/clienteLogin")
	public String efetuarLogin(Cliente cliente, RedirectAttributes ra, HttpSession session) {
		if(cliente.getEmailCliente().equals("cliente") && cliente.getPassword().equals("cliente")) {
			session.setAttribute("clienteLogado", cliente);
		} else {
			ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos");
			return "redirect:login";
		}
		return "redirect:perfil";
	}
	
	
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
}

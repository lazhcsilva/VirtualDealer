package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.model.ClienteDAO;

@Controller
public class ClienteController {

	@Autowired
	private  ClienteDAO clienteCadastroDAO;
	
	@PostMapping("/salvarFormularioCliente")
	public String salvarFormularioCliente(Cliente clienteCadastro) {
		this.clienteCadastroDAO.save(clienteCadastro);
		return "perfilcliente";
	}
	
	@GetMapping("/editarCliente")
	public String editarCliente(Integer idCliente, Model model) {
		model.addAttribute("lista", this.clienteCadastroDAO.findById(idCliente));
		return "perfilcliente";
	}
	
	@GetMapping("/apagarCliente")
	public String apagarCliente(Integer idCliente) {
		this.clienteCadastroDAO.deleteById(idCliente);
		return "index";
	}
	
}

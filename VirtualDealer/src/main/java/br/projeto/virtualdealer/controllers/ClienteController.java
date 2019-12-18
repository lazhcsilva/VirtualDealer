package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.virtualdealer.dao.ClienteDAO;
import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.model.Endereco;

@Controller
public class ClienteController {
	
	
	@Autowired
	private  ClienteDAO clienteDAO;
	
	@PostMapping("/salvarFormularioCliente")
	public String salvarFormularioCliente(Cliente cliente, Endereco endereco) {
		this.clienteDAO.save(cliente);
		return "cadastroconcluido";
	}
	
	@GetMapping("/editarCliente")
	public String editarCliente(Integer idCliente, Model model) {
		model.addAttribute("lista", this.clienteDAO.findById(idCliente));
		return "perfil";
	}
	
	@GetMapping("/apagarCliente")
	public String apagarCliente(Integer idCliente) {
		this.clienteDAO.deleteById(idCliente);
		return "index";
	}
	
}

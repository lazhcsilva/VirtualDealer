package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.virtualdealer.model.Concessionaria;
import br.projeto.virtualdealer.model.ConcessionariaDAO;

@Controller
public class ConcessionariaController {
	
	@Autowired
	private ConcessionariaDAO concessionariaCadastroDAO;

	@PostMapping("/salvarFormularioConcessionaria")
	public String salvarFormularioConcessionaria(Concessionaria concessionariaCadastro) {
		this.concessionariaCadastroDAO.save(concessionariaCadastro);
		return "perfilconcessionaria";
	}
	
	@GetMapping("/editarConcessionaria")
	public String editarConcessionaria(Integer idConcessionaria, Model model) {
		model.addAttribute("lista", this.concessionariaCadastroDAO.findById(idConcessionaria));
		return "perfilconcessionaria";
	}
	
	@GetMapping("/apagarConcessionaria")
	public String apagarConcessionaria(Integer idConcessionaria) {
		this.concessionariaCadastroDAO.deleteById(idConcessionaria);
		return "index";
	}
}

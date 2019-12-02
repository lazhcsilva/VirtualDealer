package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.projeto.virtualdealer.model.PlanoAssinaturaDAO;

@Controller
public class PlanoAssinaturaController {

	@Autowired
	private PlanoAssinaturaDAO planoAssinaturaDAO;
	
	@GetMapping("/editarDescricao")
	public String editarDescricao(Integer idPlanoAssinatura, Model model){
		model.addAttribute("lista", this.planoAssinaturaDAO.findById(idPlanoAssinatura));
		return "plano";
	}
	
}

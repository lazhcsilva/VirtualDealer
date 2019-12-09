package br.projeto.virtualdealer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.virtualdealer.dao.AssinaturaDAO;
import br.projeto.virtualdealer.model.Assinatura;

@Controller
public class AssinaturaController {

	@Autowired
	private AssinaturaDAO assinaturaDAO;
	
	@PostMapping("/salvarAssinatura")
	public String salvarAssinatura(Assinatura assinatura) {
		this.assinaturaDAO.save(assinatura);
		return "assinatura";
	}
	
	@GetMapping("/editarAssinatura")
	public String editarAssinatura(Integer idAssinatura, Model model) {
		model.addAttribute("list", this.assinaturaDAO.findById(idAssinatura));
		return "assinatura";
	}

}

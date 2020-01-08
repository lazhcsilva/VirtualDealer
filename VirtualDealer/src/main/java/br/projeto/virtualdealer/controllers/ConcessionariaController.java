package br.projeto.virtualdealer.controllers;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.projeto.virtualdealer.dao.ConcessionariaDAO;
import br.projeto.virtualdealer.model.Concessionaria;
import br.projeto.virtualdealer.service.ConcessionariaService;

@Controller
public class ConcessionariaController {
	
	@Autowired
	private ConcessionariaDAO concessionariaDAO;
	
	@Autowired
	private ConcessionariaService concessionariaService;

	@PostMapping("/salvarConcessionaria")
	public String salvarConcessionaria(@Valid Concessionaria concessionaria, BindingResult br, RedirectAttributes ra,Errors errors) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + errors.getFieldErrors());

			return "redirect:/cadastroEmpresa";
		} else {
			try {
				this.concessionariaService.salvarConcessionaria(concessionaria);
				ra.addFlashAttribute("mensagem", "Conta criada com sucesso!");
			} catch (ServiceException | MessagingException e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + e.getMessage());

				return "redirect:/cadastroEmpresa";
			}
		}
		ra.addFlashAttribute("contaCriada", true);
		return "redirect:/index";
	}
	
	@GetMapping("/editarConcessionaria")
	public String editarConcessionaria(Integer idConcessionaria, Model model) {
		model.addAttribute("lista", this.concessionariaDAO.findById(idConcessionaria));
		return "perfilconcessionaria";
	}
	
	@GetMapping("/apagarConcessionaria")
	public String apagarConcessionaria(Integer idConcessionaria) {
		this.concessionariaDAO.deleteById(idConcessionaria);
		return "index";
	}
}

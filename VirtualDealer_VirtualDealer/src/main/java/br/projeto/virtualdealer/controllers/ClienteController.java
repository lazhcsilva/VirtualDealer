package br.projeto.virtualdealer.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.projeto.virtualdealer.dao.ClienteDAO;
import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, BindingResult br, RedirectAttributes ra,Errors errors) {
		
		if (errors.hasErrors()) {
			
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + errors.getFieldErrors());

			return "redirect:/cadastro";
		
		} else {
			
			try {
				
				this.clienteService.salvarCliente(cliente);
			
			} catch (ServiceException | MessagingException e) {
				
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + e.getMessage());
				ra.addFlashAttribute("cliente", cliente);
				return "redirect:/cadastro";
			
			}
		
			ra.addFlashAttribute("message", "Conta criada com sucesso");
			
		}
		
		ra.addFlashAttribute("contaCriada", true);
		return "redirect:/cadastroefetuado";
	
	}
	
	@PostMapping("/clienteLogin")
	public String clienteLogin(HttpServletRequest request, @ModelAttribute Cliente cliente, @RequestParam(name = "retorno", required = false) String retorno, RedirectAttributes ra, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String redirect = "redirect:/index";
		if (retorno != null) {
			redirect = "redirect:" + retorno;
		}

		Cliente clienteLogado;
		try {
			clienteLogado = this.clienteService.logarCliente(cliente.getEmailCliente(), cliente.getPassword());
			session.setAttribute("usuarioLogado", clienteLogado);
		} catch (ServiceException e) {
			ra.addFlashAttribute("mensagemErro", e.getMessage());

			return "redirect:/perfil";
		}

		ra.addFlashAttribute("loginEfetuado", true);
		return "redirect:/paginaInicial";
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
	
	@GetMapping("/deslogar")
	public String deslogar(HttpSession session) {
		
		session.invalidate();
		return "redirect:/index";
		
	}
	
}

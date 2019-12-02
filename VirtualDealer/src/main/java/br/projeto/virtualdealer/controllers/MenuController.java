package br.projeto.virtualdealer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/paginaInicial")
	public String paginaInicial() {
		return "paginainicial";
	}
	
	@GetMapping("/cadastro")
	public String Cadastro() {
		return "cadastro";
	}
	
	@GetMapping("/pesquisa")
	public String pesquisa() {
		return "pesquisa";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/sobreNos")
	public String sobreNos() {
		return "sobrenos";
	}
	
	@GetMapping("/cadastroEmpresa")
	public String cadastroEmpresa() {
		return "cadastro_emp";
	}
	
	@GetMapping("/cadastroOferta")
	public String cadastroOferta() {
		return "cadastro_oferta";
	}
	
	@GetMapping("/carrinho")
	public String carrinho() {
		return "carrinh";
	}
	
	@GetMapping("/editarPerfil")
	public String editarPerfil() {
		return "editar_perfil";
	}
	
	@GetMapping("/empresas")
	public String empresas() {
		return "empresas";
	}
	
	@GetMapping("/pagamento")
	public String pagamento() {
		return "pagamento";
	}
	
	@GetMapping("/planos")
	public String planos() {
		return "planos";
	}
	
	@GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}
}
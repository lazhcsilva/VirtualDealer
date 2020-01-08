package br.projeto.virtualdealer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.projeto.virtualdealer.model.Cliente;
import br.projeto.virtualdealer.model.Concessionaria;
import br.projeto.virtualdealer.model.Endereco;

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
	public String Cadastro(Cliente cliente, Endereco endereco) {
		return "cadastro";
	}

	@GetMapping("/cadastroefetuado")
	public String Cadastroefetuadocomsucesso(Cliente cliente, Endereco endereco) {
		return "cadastroefetuadocomsucesso";
	}
	@GetMapping("/pesquisa")
	public String pesquisa() {
		return "pesquisa";
	}
	
	@GetMapping("/login")
	public String login(Cliente cliente, Model model, HttpSession session) {
		model.addAttribute("cliente", new Cliente());
		return "login";
	}
	
	@GetMapping("/sobreNos")
	public String sobreNos() {
		return "sobrenos";
	}
	
	@GetMapping("/cadastroEmpresa")
	public String cadastroEmpresa(Concessionaria concessionaria, Endereco endereco) {
		return "cadastro_emp";
	}
	
	@GetMapping("/cadastroOfertas")
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
	
	@GetMapping("/trocaSenha")
	public String trocaSenha() {
		return "senha";
	}
	
	@GetMapping("/cadastroConcluido")
	public String cadastroConcluido() {
		return "cadastroconcluido";
	}
	
	@GetMapping("/termos")
	public String termos() {
		return "termosdeuso";
	}
}
package br.projeto.virtualdealer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.projeto.virtualdealer.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

	@Query("select c from Cliente c where c.emailCliente = :emailCliente and c.password = :password")
	public Cliente clienteLogin(String email, String password);
	
	@Query("select c from Cliente c where c.emailCliente = :emailCliente")
	public Cliente findByEmailIgnoreCase(String emailCliente);
	
	@Query("select c from Cliente c where c.cpf = :cpf")
	public Cliente findByCpfIgnoreCase(String cpf);
	
}

package br.projeto.virtualdealer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.projeto.virtualdealer.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

	@Query(value = "select * from cliente where emailCliente = ?1 AND password = ?2", nativeQuery = true )
	Cliente buscaLogin(String emailCliente, String password);
	
	
}

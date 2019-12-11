package br.projeto.virtualdealer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.projeto.virtualdealer.model.Concessionaria;

public interface ConcessionariaDAO extends JpaRepository<Concessionaria, Integer> {

	@Query(value = "select * from concessionaria where emailConcessionaria = ?1 AND password = ?2", nativeQuery = true )
	Concessionaria buscaLoginConcessionaria(String emailConcessionaria, String password);
	
}

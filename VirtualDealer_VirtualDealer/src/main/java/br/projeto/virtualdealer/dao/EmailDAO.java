package br.projeto.virtualdealer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.virtualdealer.model.Email;

public interface EmailDAO extends JpaRepository<Email, Integer> {

	public Email findByToken(String token);
	
}

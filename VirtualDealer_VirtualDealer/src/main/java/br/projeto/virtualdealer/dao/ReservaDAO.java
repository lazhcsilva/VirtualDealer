package br.projeto.virtualdealer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.virtualdealer.model.Reserva;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

	
	
}

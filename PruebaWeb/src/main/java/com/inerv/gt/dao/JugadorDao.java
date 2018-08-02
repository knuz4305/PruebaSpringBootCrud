package com.inerv.gt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.inerv.gt.model.Jugador;

public interface JugadorDao extends CrudRepository<Jugador, Integer>{
	
	public List<Jugador> findAll();
	
	@Query("SELECT j FROM Jugador j WHERE j.dorsal = :dorsal")
	public Jugador findByDorsal(@Param("dorsal")String dorsal);

}

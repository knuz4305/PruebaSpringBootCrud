package com.inerv.gt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inerv.gt.dao.JugadorDao;
import com.inerv.gt.model.Jugador;

@RestController
@RequestMapping("/dataService")
public class JugadorController {

	@Autowired
	private JugadorDao daoJugador;
	
	@RequestMapping(path="/plantilla", method=RequestMethod.GET)
	public @ResponseBody List<Jugador> plantilla(){
		return (List<Jugador>) daoJugador.findAll();
	}
	
	@RequestMapping(path="/recuperaJugador", method=RequestMethod.GET)
	public @ResponseBody Jugador recuperaJugador(@RequestParam(value="dorsal")String dorsal) {
		return daoJugador.findByDorsal(dorsal);
	}
	
	@RequestMapping(path="/creaJugador", method=RequestMethod.PUT)
	public @ResponseBody Jugador creaJugador(@RequestBody Jugador jugadorInput) {
		return daoJugador.save(jugadorInput);
	}
	
	@RequestMapping(path="/actualizaJugador", method=RequestMethod.POST)
	public @ResponseBody Jugador actualizaJugador(@RequestBody Jugador jugadorInput) {
		return daoJugador.save(jugadorInput);
	}
	
	@RequestMapping(path="/borrarJugador", method=RequestMethod.DELETE)
	public @ResponseBody String borrarJugador(@RequestBody Jugador jugadorInput) {
		daoJugador.delete(jugadorInput);
		return "Jugador Eliminado.";
	}
	
}

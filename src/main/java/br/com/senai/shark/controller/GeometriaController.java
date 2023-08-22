package br.com.senai.shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.service.GeometriaService;

@RestController
public class GeometriaController {
	
	@Autowired
	private GeometriaService geometriaService;
	
	@GetMapping("/area/{tipo}")
	public String area(@PathVariable String tipo, @RequestParam(required = false) Double raio
			, @RequestParam(required = false) Double l1, @RequestParam(required = false) Double l2,
			@RequestParam(required = false) Double altura) {
		return "A área do " + tipo + " é igual a " 
			+ geometriaService.calculaArea(tipo, l1, l2, altura, raio);
	}

}

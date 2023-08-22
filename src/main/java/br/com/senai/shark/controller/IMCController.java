package br.com.senai.shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.service.IMCService;

@RestController
public class IMCController {
	
	@Autowired
	private IMCService imcService;
	
	@GetMapping("/imc")
	public String calculaIMC(@RequestParam String genero, @RequestParam Double altura, 
			@RequestParam Double peso) {
		Double imc = imcService.calculaIMC(peso, altura);
		return "IMC: " + imc + " Categoria: " + imcService.getCategoriaIMC(imc);
	}
}

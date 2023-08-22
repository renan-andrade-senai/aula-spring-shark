package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.service.NomesService;

@RestController
public class NomesController {
	
	@Autowired
	private NomesService nomesService;
	
	@GetMapping("/nomes")
	public String ordenaNomes(@RequestParam List<String> nomes) {
		nomesService.ordenaNomes(nomes);
		return nomes.toString();
	}
	
	@GetMapping("/nomes/{nomes}")
	public String ordenaNomes2(@PathVariable List<String> nomes) {
		nomesService.ordenaNomes(nomes);
		return nomes.toString();
	}

}

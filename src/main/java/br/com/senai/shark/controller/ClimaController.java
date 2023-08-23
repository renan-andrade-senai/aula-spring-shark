package br.com.senai.shark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.ClimaDto;
import br.com.senai.shark.service.ClimaService;

@RestController
@RequestMapping("/clima")
public class ClimaController {
	
	private static List<ClimaDto> climas = new ArrayList<>();
	
	@Autowired
	private ClimaService climaService;
	
	@PostMapping
	public ResponseEntity<ClimaDto> cadastraClima(@RequestBody ClimaDto clima) {
		climas.add(clima);
		return ResponseEntity.ok(clima);
	}
	
	@GetMapping("/{cidade}")
	public ResponseEntity<ClimaDto> mediaPorCidade(@PathVariable String cidade) {
		ClimaDto tempMedia = climaService.mediaPorCidade(climas, cidade);
		return ResponseEntity.ok(tempMedia);
	}

}

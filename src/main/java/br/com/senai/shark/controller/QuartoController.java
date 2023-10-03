package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.QuartoDto;
import br.com.senai.shark.model.Quarto;
import br.com.senai.shark.service.QuartoService;

@RestController
@RequestMapping("/quarto")
public class QuartoController {
	
	@Autowired
	private QuartoService quartoService;
	
	@PostMapping
	public ResponseEntity<QuartoDto> cadastrarQuarto(@RequestBody QuartoDto quartoDto) {
		Quarto quarto = quartoService.salvarQuarto(quartoDto);
		return ResponseEntity.ok(new QuartoDto(quarto));
	}
	
	@GetMapping
	public ResponseEntity<List<QuartoDto>> listarQuarto() {
		List<Quarto> quartos = quartoService.listarQuarto();
		List<QuartoDto> quartosDto = quartos.stream().map(QuartoDto::new).toList();
		return ResponseEntity.ok(quartosDto);
	}

}

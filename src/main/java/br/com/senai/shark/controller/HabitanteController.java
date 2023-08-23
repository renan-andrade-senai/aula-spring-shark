package br.com.senai.shark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.HabitanteDto;

@RestController
@RequestMapping("/habitante")
public class HabitanteController {
	
	private static List<HabitanteDto> habitantes = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<HabitanteDto> criaHabitante(@RequestBody HabitanteDto habitante) {
		habitantes.add(habitante);
		return ResponseEntity.ok(habitante);
	}
	
	@GetMapping
	public ResponseEntity<List<HabitanteDto>> listarHabitantes(@RequestParam(required = false) Double salario, 
			@RequestParam(required = false) Integer nFilhos) {
//		List<HabitanteDto> listaFiltrada = habitantes.stream().filter(h -> {
//			boolean foiFiltrado = false;
//			foiFiltrado = foiFiltrado || salario == null;
//			foiFiltrado = foiFiltrado || nFilhos == null;
//			foiFiltrado = foiFiltrado || salario < h.getSalario();
//			foiFiltrado = foiFiltrado || nFilhos < h.getnFilhos();
//			return foiFiltrado;
//		}).toList();
		List<HabitanteDto> listaFiltrada = new ArrayList<>();
		for (HabitanteDto habitanteDto : habitantes) {
			if (salario == null || salario < habitanteDto.getSalario()) {
				listaFiltrada.add(habitanteDto);
			} else if (nFilhos == null || nFilhos < habitanteDto.getnFilhos()) {
				listaFiltrada.add(habitanteDto);
			}
		}
		return ResponseEntity.ok(listaFiltrada);
	}

}

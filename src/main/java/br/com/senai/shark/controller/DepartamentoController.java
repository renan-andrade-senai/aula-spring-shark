package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.DepartamentoDto;
import br.com.senai.shark.model.Departamento;
import br.com.senai.shark.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public ResponseEntity<List<DepartamentoDto>> listarDepartamentos() {
		List<Departamento> departamentos = departamentoService.listarDepartamentos();
		List<DepartamentoDto> departamentosDto = departamentos.stream().map(DepartamentoDto::new).toList();
		return ResponseEntity.ok(departamentosDto);
	}
	
	@PostMapping
	public ResponseEntity<DepartamentoDto> cadastrarDepartamento(@RequestBody DepartamentoDto departamentoDto) {
		Departamento departamento = departamentoService.salvarDepartamento(departamentoDto);
		return ResponseEntity.ok(new DepartamentoDto(departamento));
	}

}

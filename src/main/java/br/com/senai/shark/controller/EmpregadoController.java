package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.EmpregadoDto;
import br.com.senai.shark.model.Empregado;
import br.com.senai.shark.service.EmpregadoService;

@RestController
@RequestMapping("/empregado")
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService empregadoService;
	
	@PostMapping
	public ResponseEntity<EmpregadoDto> cadastrarEmpregado(@RequestBody EmpregadoDto empregadoDto) {
		Empregado empregado = empregadoService.salvarEmpregado(empregadoDto);
		return ResponseEntity.ok(new EmpregadoDto(empregado));
	}
	
	@GetMapping
	public ResponseEntity<List<EmpregadoDto>> listarEmpregados() {
		List<Empregado> empregados = empregadoService.listarEmpregados();
		List<EmpregadoDto> empregadosDto = empregados.stream().map(EmpregadoDto::new).toList();
		return ResponseEntity.ok(empregadosDto);
	}

}

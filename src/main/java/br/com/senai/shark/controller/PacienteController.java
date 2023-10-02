package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.PacienteDto;
import br.com.senai.shark.model.Paciente;
import br.com.senai.shark.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping
	public ResponseEntity<PacienteDto> cadastrarPaciente(@RequestBody PacienteDto pacienteDto) {
		Paciente paciente = pacienteService.salvarPaciente(pacienteDto);
		return ResponseEntity.ok(new PacienteDto(paciente));
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteDto>> listarCliente() {
		List<Paciente> pacientes = pacienteService.listarPaciente();
		List<PacienteDto> pacientesDto = pacientes.stream().map(PacienteDto::new).toList();
		return ResponseEntity.ok(pacientesDto);
	}

}

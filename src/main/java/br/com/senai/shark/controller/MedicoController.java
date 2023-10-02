package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.MedicoDto;
import br.com.senai.shark.model.Medico;
import br.com.senai.shark.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	public ResponseEntity<MedicoDto> cadastrarMedico(@RequestBody MedicoDto medicoDto) {
		Medico medico = medicoService.salvarMedico(medicoDto);
		return ResponseEntity.ok(new MedicoDto(medico));
	}
	
	@GetMapping
	public ResponseEntity<List<MedicoDto>> listarMedicos() {
		List<Medico> medicos = medicoService.listarMedicos();
		List<MedicoDto> medicosDto = medicos.stream().map(MedicoDto::new).toList();
		return ResponseEntity.ok(medicosDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirMedico(@PathVariable Integer id) {
		medicoService.excluirMedico(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

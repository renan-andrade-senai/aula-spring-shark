package br.com.senai.shark.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.MotoristaDto;
import br.com.senai.shark.model.Motorista;
import br.com.senai.shark.service.MotoristaService;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {
	
	@Autowired
	private MotoristaService motoristaService;
	
	@PostMapping
	public ResponseEntity<MotoristaDto> cadastrarMotorista(@RequestBody MotoristaDto motoristaDto) {
		Motorista motorista = motoristaService.salvarMotorista(motoristaDto);
		return ResponseEntity.ok(new MotoristaDto(motorista));
	}
	
	@GetMapping
	public ResponseEntity<List<MotoristaDto>> listarMotoristas() {
		List<Motorista> motoristas = motoristaService.listarMotoristas();
		List<MotoristaDto> motoristasDto = motoristas.stream().map(MotoristaDto::new).toList();
		return ResponseEntity.ok(motoristasDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirMotorista(@PathVariable Integer id) {
		motoristaService.excluirMotorista(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<MotoristaDto> atualizarMotorista(@RequestBody MotoristaDto motoristaDto) {
		Motorista motorista = motoristaService.salvarMotorista(motoristaDto);
		return ResponseEntity.ok(new MotoristaDto(motorista));
	}
}

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

import br.com.senai.shark.dto.VeiculoDto;
import br.com.senai.shark.model.Veiculo;
import br.com.senai.shark.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping
	public ResponseEntity<VeiculoDto> cadastrarVeiculo(@RequestBody VeiculoDto veiculoDto) {
		Veiculo veiculo = veiculoService.salvarVeiculo(veiculoDto);
		return ResponseEntity.ok(new VeiculoDto(veiculo));
	}
	
	@GetMapping
	public ResponseEntity<List<VeiculoDto>> listarVeiculos() {
		List<Veiculo> veiculos = veiculoService.listarVeiculos();
		List<VeiculoDto> veiculosDto = veiculos.stream().map(VeiculoDto::new).toList();
		return ResponseEntity.ok(veiculosDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirVeiculo(@PathVariable Integer id) {
		veiculoService.excluirVeiculo(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<VeiculoDto> atualizarVeiculo(@RequestBody VeiculoDto veiculoDto) {
		Veiculo veiculo = veiculoService.salvarVeiculo(veiculoDto);
		return ResponseEntity.ok(new VeiculoDto(veiculo));
	} 

}

package br.com.senai.shark.controller;

import java.util.ArrayList;
import java.util.Comparator;
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

import br.com.senai.shark.dto.CarroDto;
import br.com.senai.shark.model.Carro;
import br.com.senai.shark.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	private static List<CarroDto> carros = new ArrayList<>();
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping
	public ResponseEntity<CarroDto> cadastraCarro(@RequestBody CarroDto carroDto) {
		Carro carro = carroService.salvarCarro(carroDto);
		return ResponseEntity.ok(new CarroDto(carro));
	}
	
	@GetMapping
	public ResponseEntity<List<CarroDto>> listarCarros() {
		List<Carro> carros = carroService.listarCarros();
		List<CarroDto> carrosDto = carros.stream().map(CarroDto::new).toList();
		
//		for (Carro carro : carros) {
//			carrosDto.add(new CarroDto(carro));
//		}
		return ResponseEntity.ok(carrosDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirCarro(@PathVariable Integer id) {
		carroService.excluirCarro(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<CarroDto> atualizaCarro(@RequestBody CarroDto carroDto) {
		Carro carroAtualizado = carroService.salvarCarro(carroDto);
		return ResponseEntity.ok(new CarroDto(carroAtualizado));
	}
	
	// Ao passar um objeto como parâmetro no método sem o @RequestParam, o Spring passa os 
	// parâmetros da url para dentro dos campos do objeto
	// Ex: http://localhost:9090/carro?marca=Ford&modelo=Ka&ano=2007; essa url iria preencher 
	// o objeto filter com o parâmetros da url
	@GetMapping("/outra-resolucao")
	public ResponseEntity<List<CarroDto>> listarCarros(CarroDto filter) {
		// O stream permite encadear filtros, chamando filter várias vezes
		List<CarroDto> listaFiltrada = carros.stream().filter(c -> filter.getMarca() == null || c.getMarca().equals(filter.getMarca()))
			.filter(c -> filter.getModelo() == null || c.getModelo().equals(filter.getModelo()))
			.filter(c -> filter.getAno() == null || c.getAno() >= filter.getAno())
		// Método sorted realiza ordenação de acordo com o comparator passado por parâmetro
			.sorted(Comparator.comparing(CarroDto::getAno)).toList();
		return ResponseEntity.ok(listaFiltrada);
	}

}

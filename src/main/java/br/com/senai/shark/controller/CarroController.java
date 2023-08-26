package br.com.senai.shark.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.CarroDto;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	private static List<CarroDto> carros = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<CarroDto> cadastraCarro(@RequestBody CarroDto carro) {
		carros.add(carro);
		return ResponseEntity.ok(carro);
	}
	
	@GetMapping
	public ResponseEntity<List<CarroDto>> listarCarros(@RequestParam(required = false) String marca, 
			@RequestParam(required = false) String modelo, 
			@RequestParam(required = false) Integer ano) {
		List<CarroDto> listaFiltrada = new ArrayList<>();
		for (CarroDto carroDto : carros) {
			if (marca == null || marca.equals(carroDto.getMarca())) {
				if (modelo == null || modelo.equals(carroDto.getModelo())) {
					if (ano == null || ano <= carroDto.getAno()) {
						listaFiltrada.add(carroDto);
					}
				}
			}
		}
		listaFiltrada.sort(Comparator.comparing(CarroDto::getAno));
		return ResponseEntity.ok(listaFiltrada);
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

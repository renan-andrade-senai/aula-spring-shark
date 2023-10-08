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

import br.com.senai.shark.dto.VendedorDto;
import br.com.senai.shark.model.Vendedor;
import br.com.senai.shark.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@PostMapping
	public ResponseEntity<VendedorDto> cadastrarVendedor(@RequestBody VendedorDto vendedorDto) {
		Vendedor vendedor = vendedorService.salvarVendedor(vendedorDto);
		return ResponseEntity.ok(new VendedorDto(vendedor));
	}
	
	@GetMapping
	public ResponseEntity<List<VendedorDto>> listarVendedores() {
		List<Vendedor> vendedores = vendedorService.listarVendedores();
		List<VendedorDto> vendedoresDto = vendedores.stream().map(VendedorDto::new).toList();
		return ResponseEntity.ok(vendedoresDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirVendedor(@PathVariable Integer id) {
		vendedorService.excluirVendedor(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<VendedorDto> atualizarVendedor(@RequestBody VendedorDto vendedorDto) {
		Vendedor vendedor = vendedorService.salvarVendedor(vendedorDto);
		return ResponseEntity.ok(new VendedorDto(vendedor));
	}
}

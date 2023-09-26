package br.com.senai.shark.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.ClienteDto;
import br.com.senai.shark.model.Cliente;
import br.com.senai.shark.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastraCliente(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.salvarCliente(clienteDto);
		return ResponseEntity.ok(new ClienteDto(cliente));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> listarClientes() {
		List<Cliente> clientes = clienteService.listarClientes();
		List<ClienteDto> clientesDto = clientes.stream().map(ClienteDto::new).toList();
		return ResponseEntity.ok(clientesDto);
	}
	
	@GetMapping("/porendereco")
	public ResponseEntity<List<ClienteDto>> listarClientesPorEndereco(@RequestParam String endereco, 
			@PageableDefault Pageable pageable) {
		List<Cliente> clientes = clienteService.listarClientePorEndereco(endereco, pageable);
		List<ClienteDto> clientesDto = clientes.stream().map(ClienteDto::new).toList();
		return ResponseEntity.ok(clientesDto);
	}
	
	@GetMapping("/pordtnascimento")
	public ResponseEntity<List<ClienteDto>> listarClientesPorDtNascimento(@RequestParam LocalDate dtNascimento,
			Pageable pageable) {
		List<Cliente> clientes = clienteService.listarClientePorDtNascimento(dtNascimento, pageable);
		List<ClienteDto> clientesDto = clientes.stream().map(ClienteDto::new).toList();
		return ResponseEntity.ok(clientesDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Integer id) {
		clienteService.excluirCliente(id);
		return ResponseEntity.status(HttpStatus.OK).build();
		// Também funciona, mas é uma pratica melhor o anterior
		//return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<ClienteDto> atualizaCliente(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = clienteService.salvarCliente(clienteDto);
		return ResponseEntity.ok(new ClienteDto(cliente));
	}

}

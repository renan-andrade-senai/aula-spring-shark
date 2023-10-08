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

import br.com.senai.shark.dto.PedidoDto;
import br.com.senai.shark.model.Pedido;
import br.com.senai.shark.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoDto> cadastrarPedido(@RequestBody PedidoDto pedidoDto) {
		Pedido pedido = pedidoService.salvarPedido(pedidoDto);
		return ResponseEntity.ok(new PedidoDto(pedido));
	}
	
	@GetMapping
	public ResponseEntity<List<PedidoDto>> listarPedidos() {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		List<PedidoDto> pedidosDto = pedidos.stream().map(PedidoDto::new).toList();
		return ResponseEntity.ok(pedidosDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirPedido(@PathVariable Integer id) {
		pedidoService.excluirPedido(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<PedidoDto> atualizarPedido(@RequestBody PedidoDto pedidoDto) {
		Pedido pedido = pedidoService.salvarPedido(pedidoDto);
		return ResponseEntity.ok(new PedidoDto(pedido));
	}
}

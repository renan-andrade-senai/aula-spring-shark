package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.PedidoDto;
import br.com.senai.shark.model.Pedido;
import br.com.senai.shark.model.Vendedor;
import br.com.senai.shark.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido(PedidoDto pedidoDto) {
		Pedido pedido = new Pedido(pedidoDto);
		if (pedidoDto.getVendedor() != null) {
			pedido.setVendedor(new Vendedor(pedidoDto.getVendedor()));
		}
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}
	
	public void excluirPedido(Integer id) {
		pedidoRepository.deleteById(id);
	}

}

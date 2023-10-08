package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}

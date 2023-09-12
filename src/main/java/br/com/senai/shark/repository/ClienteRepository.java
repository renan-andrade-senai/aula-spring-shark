package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

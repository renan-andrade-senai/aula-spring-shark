package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}

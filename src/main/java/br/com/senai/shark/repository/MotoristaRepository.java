package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {

}

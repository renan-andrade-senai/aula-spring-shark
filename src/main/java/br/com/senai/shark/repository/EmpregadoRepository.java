package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {

}

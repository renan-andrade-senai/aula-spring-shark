package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}

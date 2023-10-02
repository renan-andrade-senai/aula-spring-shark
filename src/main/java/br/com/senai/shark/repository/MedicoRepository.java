package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}

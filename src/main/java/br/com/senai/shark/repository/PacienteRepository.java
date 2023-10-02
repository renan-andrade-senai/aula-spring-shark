package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}

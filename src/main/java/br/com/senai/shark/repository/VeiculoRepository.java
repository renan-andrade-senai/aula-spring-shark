package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}

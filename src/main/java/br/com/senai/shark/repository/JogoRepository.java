package br.com.senai.shark.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {
	
	List<Jogo> findByNomePublisher(String nomePublisher, Pageable pageable);

}

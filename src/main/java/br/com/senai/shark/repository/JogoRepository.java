package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

}

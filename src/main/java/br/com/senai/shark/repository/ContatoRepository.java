package br.com.senai.shark.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	List<Contato> findByNomeAndTipo(String nome, String tipo, Pageable pageable);

}

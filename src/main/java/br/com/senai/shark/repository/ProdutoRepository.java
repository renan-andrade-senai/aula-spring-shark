package br.com.senai.shark.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	List<Produto> findByTituloAndPrazoEntrega(String titulo, LocalDate prazoEntrega, Pageable pageable);

}

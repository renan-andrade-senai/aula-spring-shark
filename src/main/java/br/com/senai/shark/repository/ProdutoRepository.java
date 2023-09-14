package br.com.senai.shark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}

package br.com.senai.shark.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.shark.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByEnderecoLike(String endereco, Pageable pageable);
	
	List<Cliente> findByDtNascimento(LocalDate dtNascimento, Pageable pageable);

}

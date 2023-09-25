package br.com.senai.shark.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import br.com.senai.shark.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	// Select * From Carro Where marca = ?
	List<Carro> findByMarca(String marca, Pageable pageable);
	
	// Select * From Carro Where modelo = ? and ano = ?
	List<Carro> findByModeloOrAno(String modelo, Integer ano);
	
	// Select * From Carro Where ano < ?
	List<Carro> findByAnoLessThan(Integer ano);
	
	// Delete Carro Where marca = ?
	@Modifying
	void deleteByMarca(String marca);

}

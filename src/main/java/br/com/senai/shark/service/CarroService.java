package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.CarroDto;
import br.com.senai.shark.model.Carro;
import br.com.senai.shark.repository.CarroRepository;
import jakarta.transaction.Transactional;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	// Serve para INSERT Ou UPDATE
	public Carro salvarCarro(CarroDto carroDto) {
		Carro carro = new Carro(carroDto);
		return carroRepository.save(carro);
	}
	
	public List<Carro> listarCarros() {
		return carroRepository.findAll();
	}
	
	public void excluirCarro(Integer id) {
		carroRepository.deleteById(id);
	}
	
	public List<Carro> listarPorMarca(String marca) {
		Pageable p = PageRequest.of(0, 20, Sort.by(Direction.DESC, "ano"));
		return carroRepository.findByMarca(marca, p);
	}
	
	public List<Carro> listarPorModeloEAno(String modelo, Integer ano) {
		return carroRepository.findByModeloOrAno(modelo, ano);
	}
	
	public List<Carro> listarPorAnoMenor(Integer ano) {
		return carroRepository.findByAnoLessThan(ano);
	}
	
	@Transactional
	public void excluirPorMarca(String marca) {
		carroRepository.deleteByMarca(marca);
	}

}

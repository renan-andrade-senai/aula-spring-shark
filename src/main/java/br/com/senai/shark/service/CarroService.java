package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.CarroDto;
import br.com.senai.shark.model.Carro;
import br.com.senai.shark.repository.CarroRepository;

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

}

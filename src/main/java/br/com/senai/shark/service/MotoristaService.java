package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.MotoristaDto;
import br.com.senai.shark.model.Motorista;
import br.com.senai.shark.repository.MotoristaRepository;

@Service
public class MotoristaService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public Motorista salvarMotorista(MotoristaDto motoristaDto) {
		Motorista motorista = new Motorista(motoristaDto);
		return motoristaRepository.save(motorista);
	}
	
	public List<Motorista> listarMotoristas() {
		return motoristaRepository.findAll();
	}
	
	public void excluirMotorista(Integer id) {
		motoristaRepository.deleteById(id);
	}

}

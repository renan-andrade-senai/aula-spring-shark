package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.VeiculoDto;
import br.com.senai.shark.model.Motorista;
import br.com.senai.shark.model.Veiculo;
import br.com.senai.shark.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo salvarVeiculo(VeiculoDto veiculoDto) {
		Veiculo veiculo = new Veiculo(veiculoDto);
		if (veiculoDto.getMotorista() != null) {
			veiculo.setMotorista(new Motorista(veiculoDto.getMotorista()));
		}
		return veiculoRepository.save(veiculo);
	}
	
	public List<Veiculo> listarVeiculos() {
		return veiculoRepository.findAll();
	}
	
	public void excluirVeiculo(Integer id) {
		veiculoRepository.deleteById(id);
	}

}

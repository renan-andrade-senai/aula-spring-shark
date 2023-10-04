package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.EmpregadoDto;
import br.com.senai.shark.model.Empregado;
import br.com.senai.shark.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	public Empregado salvarEmpregado(EmpregadoDto empregadoDto) {
		Empregado empregado = new Empregado(empregadoDto);
		return empregadoRepository.save(empregado);
	}
	
	public List<Empregado> listarEmpregados() {
		return empregadoRepository.findAll();
	}
	
	public void excluirEmpregado(Integer id) {
		empregadoRepository.deleteById(id);
	}

}

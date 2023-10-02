package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.DepartamentoDto;
import br.com.senai.shark.model.Departamento;
import br.com.senai.shark.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}
	
	public Departamento salvarDepartamento(DepartamentoDto departamentoDto) {
		Departamento departamento = new Departamento(departamentoDto);
		return departamentoRepository.save(departamento);
	}

}

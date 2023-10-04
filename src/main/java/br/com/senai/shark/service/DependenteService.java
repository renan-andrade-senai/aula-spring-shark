package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.DependenteDto;
import br.com.senai.shark.model.Dependente;
import br.com.senai.shark.model.Empregado;
import br.com.senai.shark.repository.DependenteRepository;

@Service
public class DependenteService {
	
	@Autowired
	private DependenteRepository dependenteRepository;
	
	public Dependente salvarDependente(DependenteDto dependenteDto) {
		Dependente dependente = new Dependente(dependenteDto);
		if (dependenteDto.getEmpregado() != null) {
			dependente.setEmpregado(new Empregado(dependenteDto.getEmpregado()));
		}
		return dependenteRepository.save(dependente);
	}
	
	public List<Dependente> listarDependentes() {
		return dependenteRepository.findAll();
	}

}

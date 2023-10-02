package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.MedicoDto;
import br.com.senai.shark.model.Medico;
import br.com.senai.shark.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico salvarMedico(MedicoDto medicoDto) {
		Medico medico = new Medico(medicoDto);
		return medicoRepository.save(medico);
	}
	
	public List<Medico> listarMedicos() {
		return medicoRepository.findAll();
	}
	
	public void excluirMedico(Integer id) {
		medicoRepository.deleteById(id);
	}

}

package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.PacienteDto;
import br.com.senai.shark.model.Paciente;
import br.com.senai.shark.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	public PacienteRepository pacienteRepository;
	
	public Paciente salvarPaciente(PacienteDto pacienteDto) {
		Paciente paciente = new Paciente(pacienteDto);
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> listarPaciente() {
		return pacienteRepository.findAll();
	}
	
	public void excluirPaciente(Integer id) {
		pacienteRepository.deleteById(id);
	}

}

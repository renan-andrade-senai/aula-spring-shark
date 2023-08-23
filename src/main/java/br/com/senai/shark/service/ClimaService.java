package br.com.senai.shark.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.ClimaDto;

@Service
public class ClimaService {
	
	public ClimaDto mediaPorCidade(List<ClimaDto> cidades, String cidade) {
		List<ClimaDto> novaLista = cidades.stream().filter(c -> c.getCidade().equals(cidade)).toList();
		Double soma = 0d;
		for (ClimaDto climaDto : novaLista) {
			soma += climaDto.getTemperatura();
		}
		ClimaDto tempMedia = new ClimaDto();
		tempMedia.setCidade(cidade);
		tempMedia.setTemperatura(soma / novaLista.size());
		return tempMedia;
	}

}

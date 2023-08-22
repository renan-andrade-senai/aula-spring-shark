package br.com.senai.shark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.PessoaDto;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private static List<PessoaDto> pessoas = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<PessoaDto> criaPessoa(@RequestBody PessoaDto pessoa) {
		pessoas.add(pessoa);
		return ResponseEntity.ok(pessoa);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> findPessoa(@RequestParam(required = false) String nome) {
		if (nome != null) {
//			List<PessoaDto> pessoaRetorno = new ArrayList<>();
//			for (PessoaDto pessoaDto : pessoas) {
//				if (pessoaDto.getNome().equals(nome)) {
//					pessoaRetorno.add(pessoaDto);
//				}
//			}
			List<PessoaDto> pessoaRetornoStream = pessoas.stream().filter(pessoaDto -> pessoaDto.getNome().equals(nome)).toList();
			return ResponseEntity.ok(pessoaRetornoStream);
		}
		return ResponseEntity.ok(pessoas);
	}

}

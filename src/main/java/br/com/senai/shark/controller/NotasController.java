package br.com.senai.shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.service.NotaService;

@RestController
public class NotasController {
	
	@Autowired
	private NotaService notaService;

	@GetMapping("/media")
	public String calculaMedia(@RequestParam String nome, @RequestParam String notas) {
		double media = notaService.calculaMedia(notas);
		String statusAprovacao;
		if (media >= 7) {
			statusAprovacao = "aprovado";
		} else {
			statusAprovacao = "reprovado";
		}
		return "O aluno " + nome + " foi " + statusAprovacao + " com média " + media;
	}
	
	@GetMapping("/media/{nome}/{notas}")
	public String calculaMediaPath(@PathVariable String nome, @PathVariable String notas) {
		double media = notaService.calculaMedia(notas);
		String statusAprovacao;
		if (media >= 7) {
			statusAprovacao = "aprovado";
		} else {
			statusAprovacao = "reprovado";
		}
		return "<h1>O aluno " + nome + " foi " + statusAprovacao + "</br> com média " + media + "</h1>";
	}
}

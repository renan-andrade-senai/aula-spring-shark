package br.com.senai.shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.service.HelloService;

@RestController
@RequestMapping("/ola")
public class HelloController {
	
	@Autowired
	private HelloService helloService;

	@GetMapping("/")
	public ResponseEntity<String> olaMundo(@RequestParam(defaultValue = "mundo") String nome, @RequestParam(defaultValue = "105") Integer idade) {
		helloService.validaIdade(idade);
		return ResponseEntity.ok("Olá " + nome + ", idade " + idade);
	}
	
	@GetMapping("/{nome}")
	public String olaMundoNome(@PathVariable String nome) {
		return "Olá " + nome;
	}
}

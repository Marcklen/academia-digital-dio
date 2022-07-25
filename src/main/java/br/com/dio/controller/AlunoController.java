package br.com.dio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.entity.Aluno;
import br.com.dio.entity.AvaliacaoFisica;
import br.com.dio.entity.form.AlunoForm;
import br.com.dio.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}

	@GetMapping
	public List<Aluno> getAll(@RequestParam(
			value = "dataDeNascimento", required = false) String dataDeNacimento) {
		return service.getAll(dataDeNacimento);
	}
}
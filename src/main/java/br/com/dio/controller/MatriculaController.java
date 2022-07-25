package br.com.dio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.entity.Matricula;
import br.com.dio.entity.form.MatriculaForm;
import br.com.dio.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl service;

	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}

	@GetMapping
	public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro) {
		return service.getAll(bairro);
	}
}

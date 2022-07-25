package br.com.dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.Aluno;
import br.com.dio.entity.Matricula;
import br.com.dio.entity.form.MatriculaForm;
import br.com.dio.repository.AlunoRepository;
import br.com.dio.repository.MatriculaRepository;
import br.com.dio.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public Matricula create(MatriculaForm form) {
		// TODO Auto-generated method stub
		Matricula matricula = new Matricula();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		matricula.setAluno(aluno);

		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		// TODO Auto-generated method stub
		return matriculaRepository.findById(id).get();
	}

	@Override
	public List<Matricula> getAll(String bairro) {
		// TODO Auto-generated method stub
		if (bairro == null) {
			return matriculaRepository.findAll();
		} else {
			return matriculaRepository.findAlunosMatriculadosBairro(bairro);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
}

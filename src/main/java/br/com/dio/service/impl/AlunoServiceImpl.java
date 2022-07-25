package br.com.dio.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.Aluno;
import br.com.dio.entity.AvaliacaoFisica;
import br.com.dio.entity.form.AlunoForm;
import br.com.dio.entity.form.AlunoUpdateForm;
import br.com.dio.infra.utils.JavaTimeUtils;
import br.com.dio.repository.AlunoRepository;
import br.com.dio.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	private AlunoRepository repository;

	@Override
	public Aluno create(AlunoForm form) {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());

		return repository.save(aluno);
	}

	//implementar metodo get by id
	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento) {
		// TODO Auto-generated method stub
		if (dataDeNascimento == null) {
			return repository.findAll();
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
			return repository.findByDataDeNascimento(localDate);
		}
	}

	//implementar metodo update
	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	//implementar metodo delete
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		// TODO Auto-generated method stub
		Aluno aluno = repository.findById(id).get();
		return aluno.getAvaliacoes();
	}
}
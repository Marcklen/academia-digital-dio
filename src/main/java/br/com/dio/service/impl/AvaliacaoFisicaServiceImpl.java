package br.com.dio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.Aluno;
import br.com.dio.entity.AvaliacaoFisica;
import br.com.dio.entity.form.AvaliacaoFisicaForm;
import br.com.dio.entity.form.AvaliacaoFisicaUpdateForm;
import br.com.dio.repository.AlunoRepository;
import br.com.dio.repository.AvaliacaoFisicaRepository;
import br.com.dio.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		// TODO Auto-generated method stub
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		//buscando o aluno atraves do metodo find by id
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		//setando aluno conforme os dados enviados ao form
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setPeso(form.getPeso());
		avaliacaoFisica.setAltura(form.getAltura());

		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}

	//requires more detailed implementation
	@Override
	public AvaliacaoFisica get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	//requires more detailed implementation and sending a error if is a empty list
	@Override
	public List<AvaliacaoFisica> getAll() {
		// TODO Auto-generated method stub
		return avaliacaoFisicaRepository.findAll();
	}
	//requires more detailed implementation
	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
	//requires more detailed implementation
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
}
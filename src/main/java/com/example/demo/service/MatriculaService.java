package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Aluno;
import com.example.demo.model.Matricula;
import com.example.demo.model.Turma;
import com.example.demo.repository.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	public Matricula matricularAluno(Matricula matricula) {
		calcularMedia(matricula);
		return matriculaRepository.save(matricula);
	}

	public List<Matricula> listarTodas() {
		return matriculaRepository.findAll();
	}

	public List<Matricula> listarPorAluno(Aluno aluno) {
		return matriculaRepository.findByAluno(aluno);
	}

	public List<Matricula> listarPorTurma(Turma turma) {
		return matriculaRepository.findByTurma(turma);
	}

	public void calcularMedia(Matricula matricula) {
		double n1 = matricula.getNota1() != null ? matricula.getNota1() : 0.0;
		double n2 = matricula.getNota2() != null ? matricula.getNota2() : 0.0;
		double n3 = matricula.getNota3() != null ? matricula.getNota3() : 0.0;

		double media = (n1 + n2 + n3) / 3.0;
		matricula.setMedia(media);

		if (media >= 6.0) {
			matricula.setAprovado(true);
		} else {
			matricula.setAprovado(false);
		}
	}

}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {
    	if (alunoRepository.existsByMatricula(aluno.getMatricula())) {
    		throw new RuntimeException("Já existe um aluno com essa matrícula");
    	}
        return alunoRepository.save(aluno);
    }
    
    public List<Aluno> listarTodos() {
    	return alunoRepository.findAll();
    }
    
    public Aluno buscarPorMatricula(String matricula) {
    	return alunoRepository.findByMatricula(matricula);
    }

}

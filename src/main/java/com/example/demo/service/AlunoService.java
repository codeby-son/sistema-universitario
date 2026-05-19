package com.example.demo.service;

import java.util.List;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
    private AlunoRepository alunoRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;

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
    
    public void adicionarMateria(String matriculaAluno, String codigoMateria) {

        Aluno aluno = alunoRepository.findByMatricula(matriculaAluno);

        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado");
        }

        Materia materia = materiaRepository.findByCodigo(codigoMateria);

        if (materia == null) {
            throw new RuntimeException("Matéria não encontrada");
        }

        aluno.getMaterias().add(materia);

        alunoRepository.save(aluno);
    }

}

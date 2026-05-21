package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Aluno;
import com.example.demo.model.Matricula;
import com.example.demo.model.Turma;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	List<Matricula> findByAluno(Aluno aluno);

	List<Matricula> findByTurma(Turma turma);

}

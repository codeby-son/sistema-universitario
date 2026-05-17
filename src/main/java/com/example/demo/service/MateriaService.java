package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Materia;
import com.example.demo.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	public Materia salvar(Materia materia) {
		if (materiaRepository.existsByCodigo(materia.getCodigo())) {
			throw new RuntimeException("Já existe uma matéria com esse código");
		}
		return materiaRepository.save(materia);
	}

	public List<Materia> listarTodas() {
		return materiaRepository.findAll();
	}

	public Materia buscarPorCodigo(String codigo) {
		return materiaRepository.findByCodigo(codigo);
	}
}

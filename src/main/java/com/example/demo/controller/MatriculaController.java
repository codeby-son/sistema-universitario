package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Matricula;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.TurmaRepository;
import com.example.demo.service.MatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaService matriculaService;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("matricula", new Matricula());
		model.addAttribute("alunos", alunoRepository.findAll());
		model.addAttribute("turmas", turmaRepository.findAll());
		model.addAttribute("matriculas", matriculaService.listarTodas());
		return "matriculas/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Matricula matricula) {
		matriculaService.matricularAluno(matricula);
		return "redirect:/matriculas";
	}

}

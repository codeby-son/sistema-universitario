package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import com.example.demo.service.MatriculaService;

@Controller
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	@GetMapping("/alunos")
	public String paginaAlunos(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("alunos", alunoService.listarTodos());
		model.addAttribute("alunoEncontrado", null);
		model.addAttribute("mensagemErro", null);
		return "alunos/lista";
	}
	
	@PostMapping("/alunos/salvar")
	public String salvarAluno(@ModelAttribute Aluno aluno, Model model) {
		try {
			alunoService.salvar(aluno);
			return "redirect:/alunos";
		} catch (RuntimeException e) {
			model.addAttribute("aluno", new Aluno());
			model.addAttribute("alunos", alunoService.listarTodos());
			model.addAttribute("alunoEncontrado", null);
			model.addAttribute("mensagemErro", e.getMessage());
			return "alunos/lista";
		}
	}
	
	@GetMapping("/alunos/buscar")
	public String buscarAluno(@RequestParam String matricula, Model model) {
		Aluno alunoEncontrado = alunoService.buscarPorMatricula(matricula);
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("alunos", alunoService.listarTodos());
		model.addAttribute("alunoEncontrado", alunoEncontrado);
		
		if (alunoEncontrado != null) {
			model.addAttribute("matriculas", matriculaService.listarPorAluno(alunoEncontrado));
		}
		
		model.addAttribute("mensagemErro", null);
		return "alunos/lista";
	}
	
	@PostMapping("/alunos/adicionar-materia")
	public String adicionarMateria(
	        @RequestParam String matricula,
	        @RequestParam String codigoMateria) {

	    alunoService.adicionarMateria(matricula, codigoMateria);

	    return "redirect:/alunos";
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Materia;
import com.example.demo.service.MateriaService;

@Controller
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	@GetMapping("/materias")
	public String paginaMaterias(Model model) {
		model.addAttribute("materia", new Materia());
		model.addAttribute("materias", materiaService.listarTodas());
		model.addAttribute("materiaEncontrada", null);
		model.addAttribute("mensagemErro", null);
		return "materias/lista";
	}

	@PostMapping("/materias/salvar")
	public String salvarMateria(@ModelAttribute Materia materia, Model model) {
		try {
			materiaService.salvar(materia);
			return "redirect:/materias";
		} catch (RuntimeException e) {
			model.addAttribute("materia", new Materia());
			model.addAttribute("materias", materiaService.listarTodas());
			model.addAttribute("materiaEncontrada", null);
			model.addAttribute("mensagemErro", e.getMessage());
			return "materias/lista";
		}
	}

	@GetMapping("/materias/buscar")
	public String buscarMateria(@RequestParam String codigo, Model model) {
		model.addAttribute("materia", new Materia());
		model.addAttribute("materias", materiaService.listarTodas());
		model.addAttribute("materiaEncontrada", materiaService.buscarPorCodigo(codigo));
		model.addAttribute("mensagemErro", null);
		return "materias/lista";
	}
}

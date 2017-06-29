package com.capas.uca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Materia_cursada;
import com.capas.uca.domain.Usuario;
import com.capas.uca.repository.EstudianteRepository;
import com.capas.uca.repository.UsuarioRepository;

import antlr.collections.List;


@Controller
public class MainController {

	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private EstudianteRepository er;
	
	@RequestMapping("/hola")
	 public ModelAndView iniciar(){
		ModelAndView mv = new ModelAndView();
		Usuario j = ur.findByid(2);
		Estudiante a = er.findByid(2);
		
		mv.addObject("juego",a.getMateria_cursada().get(0).getNota());
		mv.setViewName("index");
		return mv;
	}
	
}

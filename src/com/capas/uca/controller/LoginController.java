package com.capas.uca.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.domain.Usuario;
import com.capas.uca.repository.Centro_escolarRepository;
import com.capas.uca.repository.EstudianteRepository;
import com.capas.uca.repository.UsuarioRepository;

@Controller
public class LoginController {
	@Autowired
	private UsuarioRepository ur;
	
	@Autowired
	private EstudianteRepository er;
	
	@Autowired
	private Centro_escolarRepository cer;
	
	@RequestMapping("/")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") != null && h.getAttribute("id") != ""){
			Usuario u = ur.findByid(Integer.parseInt((String) h.getAttribute("id")));
			if(u.getTipo() == 0)
				mv.setViewName("admin");
			else
				mv.setViewName("coordinador");
		}else
			mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/salir")
	public  String salir(HttpServletRequest request){
		HttpSession h = request.getSession();
		try{
			h.invalidate();
		}catch(Exception e){
		}
		return "redirect:/";
	}
	
	@RequestMapping("/verificar")
	public  String verificar(HttpServletRequest request, @RequestParam String user,@RequestParam String pass ){
		ModelAndView mv = new ModelAndView();
		Usuario u = ur.findByUsuarioAndPassword(user, pass);
		HttpSession h = request.getSession();
		if(u != null && u.getEstado() == 1){
			h.setAttribute("id", ""+ u.getId());
			h.setMaxInactiveInterval(100);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/crear_cuenta")
	public ModelAndView crear_cuenta(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Usuario us = new Usuario();
		mv.addObject("ob", us);
		mv.setViewName("crearCuenta");
		return mv;
	}
	
	@RequestMapping("/guardarCuenta")
	public String guardarCuenta(@ModelAttribute("ob") Usuario u){
		u.setTipo(1);
		u.setEdad(22);
		ur.save(u);
		return "redirect:/";
	}
}

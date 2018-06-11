package com.capas.uca.controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.domain.Centro_escolar;
import com.capas.uca.domain.Departamento;
import com.capas.uca.domain.Materia;
import com.capas.uca.domain.Municipio;
import com.capas.uca.domain.Usuario;
import com.capas.uca.repository.Centro_escolarRepository;
import com.capas.uca.repository.DepartamentoRepository;
import com.capas.uca.repository.MateriaRepository;
import com.capas.uca.repository.MunicipioRepository;
import com.capas.uca.repository.UsuarioRepository;

@Controller
public class CatalosgosController {
	
	@Autowired
	private Centro_escolarRepository centro;

	@Autowired
	private DepartamentoRepository departamento;

	@Autowired
	private MateriaRepository materia;

	@Autowired
	private MunicipioRepository municipio;

	@Autowired
	private UsuarioRepository usuario;
	
	// **********************
	
	@RequestMapping("/centro_escolar")
	 public ModelAndView centro_escolar(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Centro_escolar> a = (ArrayList<Centro_escolar>) centro.findAll();
		mv.addObject("titulo", "Centro escolar");
		mv.addObject("editar", "ceEditar");
		mv.addObject("boton", "Nuevo");
		mv.addObject("crear", "crearCe");
		mv.addObject("ob",a);
		mv.setViewName("catalogo");
		return mv;
	}
	
	@RequestMapping("/ceEditar")
	 public ModelAndView ceEditar(HttpServletRequest request, @RequestParam String id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Centro_escolar a = centro.findByid(Integer.parseInt(id));
		mv.addObject("titulo", "Centro escolar");
		mv.addObject("item",a);
		mv.addObject("boton", "saveCe");
		mv.setViewName("catalogoItem");
		return mv;
	}
	
	@RequestMapping("/saveCe")
	 public String saveCe(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("descripcion") String descripcion, @RequestParam("estado") int estado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Centro_escolar e = centro.findByid(id);
		e.setEstado(estado);
		e.setDescripcion(descripcion);
		centro.save(e);
		return "redirect:/centro_escolar";
	}
	
	@RequestMapping("/crearCe")
	 public ModelAndView crearCe(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.setViewName("login");
			return mv;
		}
		Centro_escolar e = new Centro_escolar();
		mv.addObject("ob", e);
		ArrayList<Municipio> a = (ArrayList<Municipio>) municipio.findAll();
		mv.addObject("municipio", a);
		mv.setViewName("crearCentro");
		return mv;
	}
	
	@RequestMapping("/guardarCentro")
	public String guardarCuenta(HttpServletRequest request, @RequestParam("descripcion") String des, @RequestParam("municipio") int iM){
		int ad = Integer.parseInt((String) request.getSession().getAttribute("id"));
		Municipio m = municipio.findByid(iM);
		Centro_escolar u = new Centro_escolar();
		u.setDescripcion(des);
		u.setEstado(0);
		u.setFecha_creacion(Calendar.getInstance());
		u.setUsuario_creacion(ad);
		u.setFecha_modificacion(Calendar.getInstance());
		u.setUsuario_modificacion(ad);
		u.setMunicipio(m);
		
		centro.save(u);
		
		return "redirect:/";
	}
	
	// ************************
	
	@RequestMapping("/departamentos")
	 public ModelAndView departamentos(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Departamento> a = (ArrayList<Departamento>) departamento.findAll();
		mv.addObject("titulo", "Departamentos");
		mv.addObject("editar", "deEditar");
		mv.addObject("boton", "Nuevo");
		mv.addObject("ob",a);
		mv.setViewName("catalogo");
		return mv;
	}
	
	@RequestMapping("/deEditar")
	 public ModelAndView deEditar(HttpServletRequest request, @RequestParam String id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Departamento a = departamento.findByid(Integer.parseInt(id));
		mv.addObject("titulo", "Departamentos");
		mv.addObject("item",a);
		mv.addObject("boton", "saveDe");
		mv.setViewName("catalogoItem");
		return mv;
	}
	
	@RequestMapping("/saveDe")
	 public String saveDe(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("descripcion") String descripcion, @RequestParam("estado") int estado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Departamento e = departamento.findByid(id);
		e.setEstado(estado);
		e.setDescripcion(descripcion);
		departamento.save(e);
		return "redirect:/departamentos";
	}
	
	// ************************

	@RequestMapping("/municipio")
	public ModelAndView municipio(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Municipio> a = (ArrayList<Municipio>) municipio.findAll();
		mv.addObject("titulo", "Municipio");
		mv.addObject("editar", "munEditar");
		mv.addObject("boton", "Nuevo");
		mv.addObject("ob",a);
		mv.setViewName("catalogo");
		return mv;
	}

	@RequestMapping("/munEditar")
	public ModelAndView munEditar(HttpServletRequest request, @RequestParam String id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Municipio a = municipio.findByid(Integer.parseInt(id));
		mv.addObject("titulo", "Municipio");
		mv.addObject("item",a);
		mv.addObject("boton", "saveMun");
		mv.setViewName("catalogoItem");
		return mv;
	}
	
	@RequestMapping("/saveMun")
	 public String saveMun(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("descripcion") String descripcion, @RequestParam("estado") int estado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Municipio e = municipio.findByid(id);
		e.setEstado(estado);
		e.setDescripcion(descripcion);
		municipio.save(e);
		return "redirect:/municipio";
	}
	
	// ************************

	@RequestMapping("/materias")
	public ModelAndView materia(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Materia> a = (ArrayList<Materia>) materia.findAll();
		mv.addObject("titulo", "Materia");
		mv.addObject("editar", "maEditar");
		mv.addObject("boton", "Nueva");
		mv.addObject("ob",a);
		mv.addObject("boton", "saveMa");
		mv.setViewName("catalogo");
		return mv;
	}

	@RequestMapping("/maEditar")
	public ModelAndView maEditar(HttpServletRequest request, @RequestParam String id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Materia a = materia.findByid(Integer.parseInt(id));
		mv.addObject("titulo", "Materia");
		mv.addObject("item",a);
		mv.addObject("boton", "saveMa");
		mv.setViewName("catalogoItem");
		return mv;
	}
	
	@RequestMapping("/saveMa")
	 public String saveMa(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("descripcion") String descripcion, @RequestParam("estado") int estado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Materia e = materia.findByid(id);
		e.setEstado(estado);
		e.setDescripcion(descripcion);
		materia.save(e);
		return "redirect:/materias";
	}
	
	// ************************

	@RequestMapping("/usuarios")
	public ModelAndView usuarios(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Usuario> a = (ArrayList<Usuario>) usuario.findAll();
		mv.addObject("titulo", "Usuario");
		mv.addObject("editar", "usEditar");
		mv.addObject("boton", "Nueva");
		mv.addObject("ob",a);
		mv.setViewName("catalogoUsuario");
		return mv;
	}

	@RequestMapping("/usEditar")
	public ModelAndView usEditar(HttpServletRequest request, @RequestParam String id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Usuario a = usuario.findByid(Integer.parseInt(id));
		mv.addObject("titulo", "Usuarios");
		mv.addObject("boton", "saveUs");
		mv.addObject("item",a);
		mv.setViewName("catalogoItemUsuario");
		return mv;
	}
	
	@RequestMapping("/saveUs")
	 public String saveUs(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("usuario") String usuario, @RequestParam("estado") int estado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Usuario e = this.usuario.findByid(id);
		e.setEstado(estado);
		e.setUsuario(usuario);
		this.usuario.save(e);
		return "redirect:/usuarios";
	}

}

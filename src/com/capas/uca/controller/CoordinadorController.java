package com.capas.uca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capas.uca.domain.Centro_escolar;
import com.capas.uca.domain.Departamento;
import com.capas.uca.domain.Estudiante;
import com.capas.uca.domain.Expediente;
import com.capas.uca.domain.Materia;
import com.capas.uca.domain.Materia_cursada;
import com.capas.uca.domain.Municipio;
import com.capas.uca.domain.Pais;
import com.capas.uca.repository.Centro_escolarRepository;
import com.capas.uca.repository.DepartamentoRepository;
import com.capas.uca.repository.EstudianteRepository;
import com.capas.uca.repository.MateriaRepository;
import com.capas.uca.repository.Materia_cursadaRepository;
import com.capas.uca.repository.MunicipioRepository;
import com.capas.uca.repository.PaisRepository;

@Controller
public class CoordinadorController {
	
	@Autowired
	private EstudianteRepository estudiante;
	
	@Autowired
	private Materia_cursadaRepository cursada;
	
	@Autowired
	private PaisRepository pais;
	
	@Autowired
	private MateriaRepository materia;
	
	@Autowired
	private DepartamentoRepository departamento;
	
	@Autowired
	private MunicipioRepository municipio;
	
	@Autowired
	private Centro_escolarRepository centro;
	
	@RequestMapping("/coordinador")
	public ModelAndView coordinador(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		mv.setViewName("coordinador");
		return mv;
	}
	
	
	@RequestMapping("/expedientes")
	public ModelAndView expedientes(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Estudiante> e = (ArrayList<Estudiante>) estudiante.findAll();
		ArrayList<Expediente> a = new ArrayList<>();
		for(Estudiante r: e){
			int aprobadas = 0;
			int reprobadas = 0;
			float promedio = 0;
			
			for(Materia_cursada mcur: r.getMateria_cursada()){
				if(mcur.getNota() >= 6){
					aprobadas ++;
				}else{
					reprobadas++;
				}
				promedio += mcur.getNota();
			}
			promedio = promedio/(aprobadas+reprobadas);
			Expediente exp = new Expediente();
			exp.setApellido(r.getApellido());
			exp.setNombre(r.getNombre());
			exp.setId(r.getId());
			exp.setAprobadas(aprobadas);
			exp.setReprobadas(reprobadas);
			exp.setPromedio(promedio);
			a.add(exp);
		}
		mv.addObject("boton", "EditarEstudiante");
		mv.addObject("ob", a);
		mv.setViewName("expediente");
		return mv;
	}
	
	@RequestMapping("/EditarEstudiante")
	public ModelAndView EditarEstudiante(HttpServletRequest request, @RequestParam("id") int id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Estudiante e = estudiante.findByid(id);
		mv.addObject("ob", e);
		mv.setViewName("editarEstudiante");
		return mv;
	}
	
	@RequestMapping("/UpdateEstudiante")
	public String UpdateEstudiante(HttpServletRequest request, @RequestParam("id") int id,
			@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
			@RequestParam("direccion") String direccion, @RequestParam("telefono") int telefono,
			@RequestParam("celular") int celular, @RequestParam("grado_cursado") int grado_cursado,
			@RequestParam("nota_grado") float nota_grado){
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Estudiante e = estudiante.findByid(id);
		e.setNombre(nombre);
		e.setApellido(apellido);
		e.setDireccion(direccion);
		e.setTelefono(telefono);
		e.setCelular(celular);
		e.setGrado_cursado(grado_cursado);
		e.setNota_grado(nota_grado);
		estudiante.save(e);
		return "redirect:/expedientes";
	}
	
	@RequestMapping("/BuscarExpediente")
	public ModelAndView BuscarExpediente(HttpServletRequest request, @RequestParam("tipo") int id, @RequestParam("busqueda") String bus){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Estudiante> e = null;
		if(bus == null || bus == "" ){
			mv.setViewName("coordinador");
			return mv;
		}
		switch(id){
		case 0:
			e = (ArrayList<Estudiante>) estudiante.findByEdad(Integer.parseInt(bus));
			break;
		case 1:
			e = (ArrayList<Estudiante>) estudiante.findByNombreIgnoreCaseContaining(bus);
			break;
		case 2:
			e = (ArrayList<Estudiante>) estudiante.findByApellidoIgnoreCaseContaining(bus);
			break;
		case 3:
			e = (ArrayList<Estudiante>) estudiante.encontrarPorDepartamento(bus);
			break;
		case 4:
			e = (ArrayList<Estudiante>) estudiante.encontrarPorMunicipio(bus);
			break;
		}
		ArrayList<Expediente> a = new ArrayList<>();
		for(Estudiante r: e){
			int aprobadas = 0;
			int reprobadas = 0;
			float promedio = 0;
			
			for(Materia_cursada mcur: r.getMateria_cursada()){
				if(mcur.getNota() >= 6){
					aprobadas ++;
				}else{
					reprobadas++;
				}
				promedio += mcur.getNota();
			}
			promedio = promedio/(aprobadas+reprobadas);
			Expediente exp = new Expediente();
			exp.setApellido(r.getApellido());
			exp.setNombre(r.getNombre());
			exp.setId(r.getId());
			exp.setAprobadas(aprobadas);
			exp.setReprobadas(reprobadas);
			exp.setPromedio(promedio);
			a.add(exp);
		}
		mv.addObject("ob", a);
		mv.setViewName("expediente");
		return mv;
	}
	
	
	// *****************************
	
	@RequestMapping("/materiasCursadas")
	public ModelAndView materiasCursadas(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		ArrayList<Estudiante> e = (ArrayList<Estudiante>) estudiante.findAll();
		ArrayList<Expediente> a = new ArrayList<>();
		for(Estudiante r: e){
			int aprobadas = 0;
			int reprobadas = 0;
			float promedio = 0;
			
			for(Materia_cursada mcur: r.getMateria_cursada()){
				if(mcur.getNota() >= 6){
					aprobadas ++;
				}else{
					reprobadas++;
				}
				promedio += mcur.getNota();
			}
			promedio = promedio/(aprobadas+reprobadas);
			Expediente exp = new Expediente();
			exp.setApellido(r.getApellido());
			exp.setNombre(r.getNombre());
			exp.setId(r.getId());
			exp.setAprobadas(aprobadas);
			exp.setReprobadas(reprobadas);
			exp.setPromedio(promedio);
			a.add(exp);
		}
		mv.addObject("boton", "EditarCursadas");
		mv.addObject("ob", a);
		mv.setViewName("expediente");
		return mv;
	}
	
	public class tmpMateria{
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		private String materia;
		private int ano;
		private int periodo;
		private float nota;
		private int estado;
		public String getMateria() {
			return materia;
		}
		public void setMateria(String materia) {
			this.materia = materia;
		}
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		public int getPeriodo() {
			return periodo;
		}
		public void setPeriodo(int periodo) {
			this.periodo = periodo;
		}
		public float getNota() {
			return nota;
		}
		public void setNota(float nota) {
			this.nota = nota;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
			this.estado = estado;
		}
	}
	
	@RequestMapping("/EditarCursadas")
	public ModelAndView EditarCursadas(HttpServletRequest request, @RequestParam("id") int id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Estudiante e = estudiante.findByid(id);
		
		List<Materia_cursada> a = e.getMateria_cursada();
		ArrayList<tmpMateria> r = new ArrayList<>();
		
		for(Materia_cursada tm: a){
			tmpMateria h1 = new tmpMateria();
			h1.setId(tm.getId());
			h1.setAno(tm.getAno());
			h1.setEstado(tm.getMateria().getEstado());
			h1.setMateria(tm.getMateria().getDescripcion());
			h1.setNota(tm.getNota());
			h1.setPeriodo(tm.getPeriodo());
			r.add(h1);
		}
		mv.addObject("est", e);
		mv.addObject("ob", r);
		mv.setViewName("materiasCursadas");
		return mv;
	}
	
	@RequestMapping("/EditarMateriaCursada")
	public ModelAndView EditarMateriaCursada(HttpServletRequest request, @RequestParam("id") int id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		Materia_cursada e = cursada.findByid(id);
		mv.addObject("ob", e);
		mv.setViewName("editarMateriaCursada");
		return mv;
	}
	
	@RequestMapping("/GuardarMateriaCursada")
	public String GuardarMateriaCursada(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("periodo") int periodo, @RequestParam("ano") int ano,  @RequestParam("nota") float nota
			){
		
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Materia_cursada e = cursada.findByid(id);
		e.setNota(nota);
		e.setPeriodo(periodo);
		e.setAno(ano);
		cursada.save(e);
		return "redirect:/materiasCursadas";
	}
	
	@RequestMapping("/AgregarMateriaCur")
	public ModelAndView AgregarMateriaCur(HttpServletRequest request, @RequestParam("id") int id){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		mv.addObject("id", id);
		List<Materia> e = materia.findAll();
		mv.addObject("materia", e);
		mv.setViewName("agregarMateriaCur");
		return mv;
	}
	
	@RequestMapping("/GuardarMateriaCur")
	public String GuardarMateriaCur(HttpServletRequest request, @RequestParam("id") int id, 
			 @RequestParam("periodo") int periodo, @RequestParam("ano") int ano,  @RequestParam("nota") float nota,
			 @RequestParam("materia") int materia
			){
		
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		Estudiante es = estudiante.findByid(id);
		Materia mat = this.materia.findByid(materia);
		
		Materia_cursada e = new Materia_cursada();
		e.setMateria(mat);
		e.setEstudiante(es);
		e.setNota(nota);
		e.setPeriodo(periodo);
		e.setAno(ano);
		cursada.save(e);
		return "redirect:/materiasCursadas";
	}
	
	
	@RequestMapping("/CrearExpediente")
	public ModelAndView CrearExpediente(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			mv.addObject("mensaje",1);
			mv.setViewName("login");
			return mv;
		}
		List<Pais> p = pais.findAll();
		List<Departamento> d = departamento.findAll();
		List<Municipio> m = municipio.findAll();
		List<Centro_escolar> ce = centro.findAll();
		
		
		
		mv.addObject("pais", p);
		mv.addObject("departamento", d);
		mv.addObject("municipio", m);
		mv.addObject("centro_escolar", ce);
		mv.setViewName("CrearExpediente");
		return mv;
	}
	
	@RequestMapping("/gExpediente")
	public String gExpediente(HttpServletRequest request){
		
		HttpSession h = request.getSession();
		if(h.getAttribute("id") == null || h.getAttribute("id") == ""){
			h.invalidate();
			return "redirect:/";
		}
		
		return "redirect:/materiasCursadas";
	}
	
}

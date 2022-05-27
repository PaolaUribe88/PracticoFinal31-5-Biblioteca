package cl.aiep.java.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.aiep.java.biblioteca.modelo.Autor;
import cl.aiep.java.biblioteca.modelo.Libro;
import cl.aiep.java.biblioteca.repository.AutorRepository;
import cl.aiep.java.biblioteca.repository.LibroRepository;

@Controller
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	LibroRepository libroRepository;
	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping ("/index")//http://localhost:8081/ AL NO TENER UN ASIGNADO SE ABRE DESDE EL NAVEGADOR DIRECTAMENTE EN EL LOCALHOST
	public String index() {
		
		return "index";//NOMBRE DE LA PLANTILLA DE Thymeleaf(sin html)
	}
	
	@GetMapping("/nuevo")
	public String nuevoLibro(Libro libro, Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores",autores);
		return "libro/form";
	}
	@PostMapping("/procesar")
	public String procesarLibro(@Valid Libro libro, BindingResult validacion) {
		
		if(validacion.hasErrors()) {
			return "libro/form";
		}
		if(libro.getId() == null || libro.getId() == 0) {
			libroRepository.crear(libro);
			
		}else {
			libroRepository.editar(libro);
			
		}
			return"redirect:/libro/listado";
	}
	@GetMapping("/listado")
	public String listarLibro(Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libros", libros);
		return "libro/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String editarLibro(@PathVariable Long id , Model modelo) {
		Libro libro = libroRepository.findById(id);
		modelo.addAttribute("libro", libro);
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores", autores);
		return "libro/form";
	}
	
	@GetMapping("/eliminar")
	public String eliminarLibro(@RequestParam(name="id", required = true)Long id) {
		libroRepository.eliminar(id);
		return "redirect:/libro/listado";
	}
	@GetMapping("/buscar")
	public String buscarLibro(@RequestParam(name="q", required = true)String titulo, Model modelo) {
		List<Libro> libros = libroRepository.findByTitle(titulo);
		modelo.addAttribute("libros", libros);
		return "/listadoInicio";
	}
		
}

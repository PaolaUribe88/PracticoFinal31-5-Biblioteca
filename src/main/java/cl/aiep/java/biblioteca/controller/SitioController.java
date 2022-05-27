package cl.aiep.java.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.aiep.java.biblioteca.modelo.Libro;
import cl.aiep.java.biblioteca.repository.LibroRepository;

@Controller
public class SitioController {
	@Autowired
	LibroRepository libroRepository;

	@GetMapping ({"/", "/inicio"})
	public String inicio() {//PUEDE SER INDEX TAMBIEN
		return "inicio";
	}
	
	@GetMapping("/listadoInicio")
	public String listarLibroInicio(Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libros", libros);
		return "listadoInicio";
	}
}
